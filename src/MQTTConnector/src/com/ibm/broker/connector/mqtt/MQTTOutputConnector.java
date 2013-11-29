//***************************************************************
//
// Source File Name: MQTTOutputConnector
//
// Description: This file contains the MQTTOutputConnector class.
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

import static com.ibm.broker.connector.ContainerServices.writeServiceTraceEntry;
import static com.ibm.broker.connector.ContainerServices.writeServiceTraceExit;

import java.util.Properties;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.ibm.broker.connector.AdminInterface;
import com.ibm.broker.connector.ConnectorFactory;
import com.ibm.broker.connector.OutputConnector;
import com.ibm.broker.connector.OutputInteraction;
import com.ibm.broker.plugin.MbException;

public class MQTTOutputConnector extends OutputConnector implements AdminInterface {
    public static final String copyright = Copyright.LONG;
    private static final String clsName = MQTTOutputConnector.class.getName();

    private String connectionUrl = null;
    public static final String[] ADMINTYPES = new String[] { "Connections" };

    public MQTTOutputConnector(ConnectorFactory connectorFactory, 
                               String name,
                               Properties properties) throws MbException 
    {
        super(connectorFactory, name, properties);
    }

    @Override
    public OutputInteraction createOutputInteraction() throws MbException {
        writeServiceTraceEntry(clsName, "createOutputInteraction", "Entry");
        try {
	        String clientName = null;
	        String connectionUrl = getProperties().getProperty("connectionUrl");
	
	        // Default the URL if not set.
	        if (getProperties().getProperty("connectionUrl") == null) {
	            connectionUrl = MQTTConnectorFactory.DEFAULT_MQTT_URL;
	        }
	
	        String clientId = getProperties().getProperty("clientId");
	        if (clientId == null) {
	            clientName = getConnectorFactory().getContainerServices().containerName() + getName() + "_" + getInteractions().length;
	        } else {
	            clientName = clientId + "_" + getInteractions().length;
	        }
	        MQTTOutputInteraction newContext = new MQTTOutputInteraction(this, connectionUrl, clientName);
	
	        return newContext;
        }
        finally {
            writeServiceTraceExit(clsName, "createOutputInteraction", "Exit");
        }
    }

    @Override
    public void terminate() throws MbException {
        writeServiceTraceEntry(clsName, "terminate", "Entry");
        writeServiceTraceExit(clsName, "terminate", "Exit");
    }

    @Override
    public String[] listAdminObjectTypes() throws MbException {
        writeServiceTraceEntry(clsName, "listAdminObjectTypes", "Entry");
        writeServiceTraceExit(clsName, "listAdminObjectTypes", "Exit");
        return ADMINTYPES;
    }

    @Override
    public String[] listAdminObjectsForType(String adminObjectType) throws MbException {
        writeServiceTraceEntry(clsName, "listAdminObjectsForType", "Entry");
        try {
	        String[] returnValue = null;
	        
	        if (adminObjectType.equals("Connections")) {
	            OutputInteraction[] interactions = getInteractions();
	            returnValue = new String[interactions.length];
	            for (int i = 0; i < interactions.length; i++) {
	                returnValue[i] = ((MQTTOutputInteraction) interactions[i])
	                        .getClient().getClientId();
	            }
	        }
	        return returnValue;
        }
        finally {
            writeServiceTraceExit(clsName, "listAdminObjectsForType", "Exit");
        }
    }

    @Override
    public Properties listAdminObjectProperties(String adminObjectType, String adminObjectName) throws MbException {
        writeServiceTraceEntry(clsName, "listAdminObjectProperties", "Entry");

        try {
			Properties properties = new Properties();
			if (adminObjectType.equals("Connections")) {
				OutputInteraction[] interactions = getInteractions();
				MQTTOutputInteraction clientName = null;
				for (int i = 0; i < interactions.length; i++) {
					if (((MQTTOutputInteraction) interactions[i]).getClient()
							.getClientId().equals(adminObjectName)) {
						clientName = ((MQTTOutputInteraction) interactions[i]);
						break;
					}
				}
				properties.put("isConnected", clientName.getClient()
						.isConnected());
				properties.put("serverURI", clientName.getClient()
						.getServerURI());
				properties.put("numberOfPendingDeliveryTokens", clientName
						.getClient().getPendingDeliveryTokens().length);
			}
			return properties;
		} finally {
			writeServiceTraceExit(clsName, "listAdminObjectProperties", "Exit");
		}
    }

    @Override
    public void changeAdminObject(String function, 
                                  Properties newProperties, 
                                  String adminObjectType, 
                                  String adminObjectName) throws MbException 
    {
        writeServiceTraceEntry(clsName, "changeAdminObject", "Entry");
        
        try {
			if (adminObjectType.equals("Connections")
			 && function.equalsIgnoreCase("disconnect")) {
			    OutputInteraction[] interactions = getInteractions();
			    if (!adminObjectName.equals("")) {
			        MQTTOutputInteraction clientName = null;
			        for (int i = 0; i < interactions.length; i++) {
			            if (((MQTTOutputInteraction) interactions[i]).getClient()
			                    .getClientId().equals(adminObjectName)) {
			                clientName = ((MQTTOutputInteraction) interactions[i]);
			                break;
			            }
			        }
			        if (clientName != null) {
			            try {
			                clientName.getClient().disconnect();
			            }
			            catch (MqttException e) {
			                e.printStackTrace();
			            }
			        }
			    } else {
			        for (int index = 0; index < interactions.length; index++) {
			            try {
			                ((MQTTOutputInteraction) interactions[index]).getClient().disconnect();
			            }
			            catch (MqttException e) {
			                e.printStackTrace();
			            }
			        }
			    }
			}
		} finally {
	        writeServiceTraceExit(clsName, "changeAdminObject", "Exit");
		}
    }

    @Override
    public String adminKey() throws MbException {
        writeServiceTraceEntry(clsName, "adminKey", "Entry");
        writeServiceTraceExit(clsName, "adminKey", "Exit");
        return null;
    }

    @Override
    public void initialize() throws MbException {
        writeServiceTraceEntry(clsName, "initialize", "Entry");
        try {
			connectionUrl = getProperties().getProperty("connectionUrl");
			if (connectionUrl == null) {
				connectionUrl = MQTTConnectorFactory.DEFAULT_MQTT_URL;
			}
			connectionUrl = connectionUrl.trim();
			connectionUrl = connectionUrl.toLowerCase();
			if (connectionUrl.startsWith("tcp://") == false) {
				getConnectorFactory().getContainerServices()
						.throwMbRecoverableException("2111",
								new String[] { "not a tcp:// url" });
			}
			String portNumber = connectionUrl.substring(6);
			int startOfPort = portNumber.indexOf(":");
			if (startOfPort > -1 && startOfPort < portNumber.length() - 2) {
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
		} finally {
			writeServiceTraceExit(clsName, "initialize", "Exit");
		}
    }
}
