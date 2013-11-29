//***************************************************************
//
// Source File Name: MQTTInputConnector
//
// Description: This file contains the MQTTInputConnector class.
//
/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and other Contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM - initial implementation
 *******************************************************************************/


package com.ibm.broker.connector.mqtt;

import static com.ibm.broker.connector.ContainerServices.writeServiceTraceData;
import static com.ibm.broker.connector.ContainerServices.writeServiceTraceEntry;
import static com.ibm.broker.connector.ContainerServices.writeServiceTraceExit;

import java.util.Properties;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttDefaultFilePersistence;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.MqttTopic;

import com.ibm.broker.connector.AdminInterface;
import com.ibm.broker.connector.ConnectorFactory;
import com.ibm.broker.connector.Event;
import com.ibm.broker.connector.EventInputConnector;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbRecoverableException;

public class MQTTInputConnector extends EventInputConnector implements AdminInterface, MqttCallback {
    public static final String copyright = Copyright.LONG;
    private static final String clsName = MQTTInputConnector.class.getName();

    private MqttClient client;
    private int countMessages = 0;
    private int checkPointCount = 10000;
    private boolean failedToConnect = false;
    private Properties activityLogTag = new Properties();
    private String connectionUrl = null;
    private MqttDefaultFilePersistence dataStore;
    
    // The BIP messages will come from the Integration Bus-provided catalog.
    public static final String MESSAGE_CATALOG_NAME = "BIPmsgs";
    public static final String[] ADMINTYPES = new String[]{"Connections"};
    
    public MQTTConnectorFactory getMQTTFactory() throws MbException{
        return (MQTTConnectorFactory)getConnectorFactory();
    }
    
    @Override
    public void logNoEvent() throws MbException {
        writeServiceTraceEntry(clsName, "logNoEvent", "Entry");

        try {
			// Use BIP12066 as a message to write out activity log entries
			writeActivityLog("12066",
					new String[] { "" + getProperties().get("topicName") },
					activityLogTag);
		} finally {
			writeServiceTraceExit(clsName, "logNoEvent", "Exit");
		}
    }

    
    public MQTTInputConnector(ConnectorFactory connectorFactory, String name, Properties properties) throws MbException {
        super(connectorFactory, name, properties);
    }
    
    public Properties getActivityLogTag() {
        return activityLogTag;
    }

    public MqttClient getClient() {
        return client;
    }

    @Override
    public String[] listAdminObjectTypes() throws MbException {
        return ADMINTYPES;
    }

    @Override
    public String[] listAdminObjectsForType(String adminObjectType) throws MbException 
    {
        writeServiceTraceEntry(clsName, "listAdminObjectsForType", "Entry");
        
        try {
			// Wait up to 10 seconds, checking each second if the client has been setup.
			for (int i = 0; i < 10 && client == null; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (client == null) {
				throw new MbRecoverableException(this,
						"listAdminObjectsForType", MESSAGE_CATALOG_NAME,
						"BIP2111", "Client null",
						new String[] { "Client null" });
			}
			String[] returnValue = new String[] { client.getClientId() };
			return returnValue;
		} finally {
			writeServiceTraceExit(clsName, "listAdminObjectsForType", "Exit");
		}
    }

    @Override
    public Properties listAdminObjectProperties(String adminObjectType, String adminObjectName) throws MbException {
        writeServiceTraceEntry(clsName, "listAdminObjectProperties", "Entry");
        
        Properties properties = new Properties();
        if(adminObjectType.equals("Connections")){
            properties.put("isConnected", client.isConnected());
            properties.put("pendingDeliveryTokens", client.getPendingDeliveryTokens().length);
        }
        
        writeServiceTraceExit(clsName, "listAdminObjectProperties", "Exit");
        return properties;
    }
    
    @Override
    public void changeAdminObject(String adminFunction,
                                  Properties adminParamters, 
                                  String adminObjectType,
                                  String adminObjectName) throws MbException 
    {
       writeServiceTraceEntry(clsName, "changeAdminObject", "Entry");
       
       try {
			if (adminFunction.equals("connect")) {
				try {
					writeServiceTraceData(clsName, "changeAdminObject",
							"Attempting to connect ...");
					client.connect();
					writeServiceTraceData(clsName, "changeAdminObject",
							"Connected OK.");
				} catch (MqttSecurityException e) {
					getConnectorFactory().getContainerServices()
							.throwMbRecoverableException(e);
				} catch (MqttException e) {
					getConnectorFactory().getContainerServices()
							.throwMbRecoverableException(e);
				}
			} else if (adminFunction.equals("disconnect")) {
				try {
					client.disconnect();
				} catch (MqttException e) {
					getConnectorFactory().getContainerServices()
							.throwMbRecoverableException(e);
				}
			}
		} finally {
			writeServiceTraceExit(clsName, "changeAdminObject", "Exit");
		}
    }
    
    @Override
    public void initialize() throws MbException  {
        writeServiceTraceEntry(clsName, "initialize", "Entry");
        
        try {
			// Tag activity log entries with the topic
			activityLogTag.put("Topic", getProperties()
					.getProperty("topicName"));
			connectionUrl = getProperties().getProperty("connectionUrl");
			if (connectionUrl == null) {
				connectionUrl = MQTTConnectorFactory.DEFAULT_MQTT_URL;
			} else {
				// Tidy up the URL
				connectionUrl = connectionUrl.trim().toLowerCase();
			}
			if (connectionUrl.startsWith("tcp://") == false) {
				getConnectorFactory().getContainerServices()
						.throwMbRecoverableException("2111",
								new String[] { "not a tcp:// url" });
			}
			// Strip off the leading protocol (tcp://)
			String portNumber = connectionUrl.substring(6);
			// Then find the port (the 2nd colon in the string, having stripped off the protocol)
			int startOfPort = portNumber.indexOf(":");
			if ((startOfPort > -1) && (startOfPort < portNumber.length() - 2)) {
				portNumber = portNumber.substring(startOfPort + 1);
			}
			try {
				Integer.parseInt(portNumber);
			} catch (NumberFormatException e) {
				getConnectorFactory().getContainerServices()
						.throwMbRecoverableException(
								"2112",
								new String[] { "not a valid integer",
										portNumber });
			}
			activityLogTag.put("connectionUrl", connectionUrl);
		} finally {
			writeServiceTraceExit(clsName, "initialize", "Exit");
		}
    }

    @Override
    public void start() throws MbException  {
        writeServiceTraceEntry(clsName, "start", "Entry");
        
        try {
			String connectionUrl = getProperties().getProperty("connectionUrl");
			String clientId = getProperties().getProperty("clientId");
			String clientName = clientId;
			if (connectionUrl == null) {
				connectionUrl = MQTTConnectorFactory.DEFAULT_MQTT_URL;
			}
			if (clientId == null) {
				clientName = getConnectorFactory().getContainerServices()
						.containerName() + getName();
			}
			if (clientName.length() > 23) {
				clientName = clientName.substring(clientName.length() - 23);
			}
			try {
				dataStore = new MqttDefaultFilePersistence(
						getConnectorFactory().getContainerServices()
								.getWorkDirectory()
								+ getConnectorFactory().getContainerServices()
										.getFileSeparator()
								+ clientName
								+ System.currentTimeMillis());
				client = new MqttClient(connectionUrl, clientName, dataStore);
				writeServiceTraceData(clsName, "start",
						"Attempting to connect ...");
				client.connect();
				writeServiceTraceData(clsName, "start", "Connected OK.");
				client.setCallback(this);
				client.subscribe(getProperties().getProperty("topicName"));
				failedToConnect = false;
			} catch (MqttPersistenceException e) {
				if (failedToConnect == false) {
					failedToConnect = true;

					writeActivityLog("12067", new String[] { connectionUrl },
							activityLogTag);
					writeActivityLog("12071", new String[] { connectionUrl },
							activityLogTag);
				}
				getConnectorFactory().getContainerServices()
						.throwMbRecoverableException("12067",
								new String[] { connectionUrl });
			} catch (MqttException e) {
				if (failedToConnect == false) {
					failedToConnect = true;

					writeActivityLog("12067", new String[] { connectionUrl },
							activityLogTag);
					writeActivityLog("12071", new String[] { connectionUrl },
							activityLogTag);
				}
				getConnectorFactory().getContainerServices()
						.throwMbRecoverableException("12067",
								new String[] { connectionUrl });
			}
			writeActivityLog("12063", new String[] { connectionUrl },
					activityLogTag);
		} finally {
			writeServiceTraceExit(clsName, "start", "Exit");
		}
    }
    
    public void stop() throws MbException  {
        writeServiceTraceEntry(clsName, "stop", "Entry");
        try {
            client.unsubscribe(getProperties().getProperty("topicName"));
            client.disconnect(5000);
        } 
        catch (MqttPersistenceException e) {
            throw new MbRecoverableException(this, "createOutputContext", MESSAGE_CATALOG_NAME, "BIP2111", "MQTT error", new String[]{"MQTT error"});
        } 
        catch (MqttException e) {
            throw new MbRecoverableException(this, "createOutputContext", MESSAGE_CATALOG_NAME, "BIP2111", "MQTT error", new String[]{"MQTT error"});
        }
        finally {
        	writeServiceTraceExit(clsName, "stop", "Exit");
        }
    }
    
    @Override
    public void connectionLost(Throwable arg0) {
        writeServiceTraceEntry(clsName, "connectionLost", "Entry");
        try {
            writeActivityLog("12062", new String[]{getProperties().getProperty("connectionUrl")},activityLogTag);
            String lastMessageKey = "";
            while(isStarted() && client.isConnected() == false){
                try {
                  start(); 
                } catch (MbException e) {
                    try {
                        if(lastMessageKey.equals(e.getMessageKey()) == false){
                          getConnectorFactory().getContainerServices().writeSystemLogError(e.getMessageKey(), (String[])e.getInserts());
                        }
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                    }
                }
            }
        } catch (MbException e) {
            try {
                getConnectorFactory().getContainerServices().writeSystemLogError("2111", new String[]{arg0.getLocalizedMessage()});
            } catch (MbException e1) {
            }
        }
        finally {
        	writeServiceTraceExit(clsName, "stop", "Exit");
        }
    }

    @Override
    public void deliveryComplete(MqttDeliveryToken arg0) {
        writeServiceTraceEntry(clsName, "deliveryComplete", "Entry");
        writeServiceTraceExit(clsName, "deliveryComplete", "Exit");
    }

    @Override
    public void messageArrived(MqttTopic topic, MqttMessage message)
            throws Exception {
        writeServiceTraceEntry(clsName, "messageArrived", "Entry");
        try {
			countMessages++;
			int totalMessage = countMessages;
			if (totalMessage > checkPointCount) {
				synchronized (this) {
					if (totalMessage > checkPointCount) {
						checkPointCount += 10000;
						writeServiceTraceData(clsName, "messageArrived", ""
								+ System.currentTimeMillis() / 1000
								+ " countMessages: " + totalMessage);
					}
				}
			}
			Event[] events = new Event[1];
			events[0] = new MQTTEvent(topic, message);
			deliverEvents(events);
		} finally {
			writeServiceTraceExit(clsName, "messageArrived", "Exit");
		}
   }


    @Override
    public String adminKey() throws MbException {
        writeServiceTraceEntry(clsName, "adminKey", "Entry");
        writeServiceTraceExit(clsName, "adminKey", "Exit");
        return null;
    }

}
