//***************************************************************
//
// Source File Name: MQTTOutputInteraction
//,
// Description: This file contains the MQTTOutputInteraction class.
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

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttDefaultFilePersistence;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.MqttTopic;

import com.ibm.broker.connector.OutputConnector;
import com.ibm.broker.connector.OutputInteraction;
import com.ibm.broker.connector.OutputRecord;
import com.ibm.broker.plugin.MbException;

public class MQTTOutputInteraction extends OutputInteraction {
    private static final String clsName = MQTTOutputInteraction.class.getName();
    Properties topicTag = new Properties();
    
    @Override
    public void logSend() throws MbException {
        topicTag.put("Topic", sentDestination());
        getConnector().writeActivityLog("12064", new String[]{sentDestination()},topicTag);
    }

    public static final String copyright = Copyright.LONG;

    private MqttClient client;
    public MqttClient getClient() {
        return client;
    }

    private MqttDefaultFilePersistence dataStore;
    
    private String topicName = null;
    MQTTOutputConnector getMQTTSession() throws MbException{
        return (MQTTOutputConnector)getConnector();
    }
    public MQTTOutputInteraction(OutputConnector connector,String connectionUrl, String clientId) throws MbException{
        super(connector);
        writeServiceTraceEntry(clsName, "MQTTOutputInteraction", "Entry");
        try {
			topicTag.put("Topic", connector.getProperties().get("topicName"));
			topicTag.put("connectionUrl", connector.getProperties()
					.get("connectionUrl"));
			String clientNameTrun = null;
			if (clientId.length() > 23) {
				clientNameTrun = clientId.substring(clientId.length() - 23);
			} else {
				clientNameTrun = clientId;
			}
			try {
				dataStore = new MqttDefaultFilePersistence(getConnector()
						.getConnectorFactory().getContainerServices()
						.getWorkDirectory()
						+ getConnector().getConnectorFactory()
								.getContainerServices().getFileSeparator()
						+ clientNameTrun + System.currentTimeMillis());
				client = new MqttClient(connectionUrl, clientNameTrun, dataStore);
				writeServiceTraceData(clsName, "MQTTOutputInteraction",
						"Attempting to connect ...");
				client.connect();
				writeServiceTraceData(clsName, "MQTTOutputInteraction",
						"Connected OK.");
			} catch (MqttException e) {
				getConnector().writeActivityLog("12067",
						new String[] { connectionUrl }, topicTag);
				getConnector()
						.getConnectorFactory()
						.getContainerServices()
						.throwMbRecoverableException("12067",
								new String[] { connectionUrl });
			}
			getConnector()
					.writeActivityLog(
							"12063",
							new String[] { ""
									+ getConnector().getProperties().get(
											"connectionUrl") }, topicTag);
		} finally {
	        writeServiceTraceExit(clsName, "MQTTOutputInteraction", "Exit");
		}
    }
    
    @Override
    public Properties send(Properties overrideProps, OutputRecord record) throws MbException {
        writeServiceTraceEntry(clsName, "send", "Entry");
        try {
			writeServiceTraceData(clsName, "send", overrideProps.toString());
			if (!client.isConnected()) {
				try {
					writeServiceTraceData(clsName, "send",
							"Attempting to connect ...");
					client.connect();
					writeServiceTraceData(clsName, "send", "Connected OK.");
				} catch (MqttSecurityException e) {
					getConnector().writeActivityLog(
							"12067",
							new String[] { ""
									+ getConnector().getProperties().get(
											"connectionUrl") }, topicTag);
					getConnector()
							.getConnectorFactory()
							.getContainerServices()
							.throwMbRecoverableException(
									"12067",
									new String[] { ""
											+ getConnector().getProperties()
													.get("connectionUrl") });
				} catch (MqttException e) {
					getConnector().writeActivityLog(
							"12067",
							new String[] { ""
									+ getConnector().getProperties().get(
											"connectionUrl") }, topicTag);
					getConnector()
							.getConnectorFactory()
							.getContainerServices()
							.throwMbRecoverableException(
									"12067",
									new String[] { ""
											+ getConnector().getProperties()
													.get("connectionUrl") });
				}
				getConnector().writeActivityLog(
						"12063",
						new String[] { ""
								+ getConnector().getProperties().get(
										"connectionUrl") }, topicTag);
			}
			String overrideTopic = overrideProps.getProperty("TopicName");
			if (overrideTopic == null) {
				topicName = getConnector().getProperties().getProperty(
						"topicName");
			} else {
				topicName = overrideTopic;
			}
			MqttTopic topic = client.getTopic(topicName);
			// Construct the message to publish
			MqttMessage message = new MqttMessage(record.getByteData());
			String qos = getConnector().getProperties().getProperty(
					"qualityOfService");
			if (qos == null) {
				message.setQos(0);
			} else {
				message.setQos(Integer.parseInt(qos));
			}
			MqttDeliveryToken token = null;
			try {
				writeServiceTraceData(clsName, "send", "Sending: " + record.getUTF8Data());
				token = topic.publish(message);
				token.waitForCompletion();
			} catch (MqttPersistenceException e) {
				getConnector().getConnectorFactory().getContainerServices()
						.throwMbRecoverableException(e);
			} catch (MqttException e) {
				getConnector().getConnectorFactory().getContainerServices()
						.throwMbRecoverableException(e);
			}
			Properties returnProperties = new Properties();
			if (token != null) {
				returnProperties.put("DeliveryToken/isComplete",
						token.isComplete());
			}
			returnProperties.put("ClientId", client.getClientId());
			writeServiceTraceData(clsName, "send", "Returning: " + returnProperties.toString());
			return returnProperties;
		} finally {
			writeServiceTraceExit(clsName, "send", "Exit");
		}
    }
    
    @Override
    public String sentDestination(){
        return topicName;
    }

    @Override
    public void terminate() throws MbException {
        writeServiceTraceEntry(clsName, "terminate", "Entry");
        try {
            client.disconnect();
            dataStore.clear();
            dataStore.close();
        } catch (MqttException e) {
            getConnector().getConnectorFactory().getContainerServices().throwMbRecoverableException(e);
        }
        finally {
            writeServiceTraceExit(clsName, "terminate", "Exit");
        }
    }
}
