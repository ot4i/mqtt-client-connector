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

import java.util.Properties;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.ibm.broker.connector.AdminInterface;
import com.ibm.broker.connector.ConnectorFactory;
import com.ibm.broker.connector.OutputConnector;
import com.ibm.broker.connector.OutputInteraction;
import com.ibm.broker.plugin.MbException;

public class MQTTOutputConnector extends OutputConnector implements AdminInterface {
    public static final String copyright = Copyright.LONG;

    public MQTTTrace trace = null;
    private String brokerUrl = null;
    public static final String[] ADMINTYPES = new String[] { "Connections" };

    public MQTTOutputConnector(ConnectorFactory connectorFactory, 
                               String name,
                               Properties properties) throws MbException 
    {
        super(connectorFactory, name, properties);
        if (properties.get("traceOn") != null) {
            trace = new MQTTTrace(connectorFactory, properties);
        }
    }

    @Override
    public OutputInteraction createOutputInteraction() throws MbException {
        if (trace != null) trace.testEntry("createOutputInteraction");
        String clientName = null;
        String brokerUrl = getProperties().getProperty("brokerUrl");

        // Default the URL if not set.
        if (getProperties().getProperty("brokerUrl") == null) {
            brokerUrl = MQTTConnectorFactory.DEFAULT_MQTT_URL;
        }

        String clientId = getProperties().getProperty("clientId");
        if (clientId == null) {
            clientName = getConnectorFactory().getContainerServices().containerName() + getName() + "_" + getInteractions().length;
        } else {
            clientName = clientId + "_" + getInteractions().length;
        }
        MQTTOutputInteraction newContext = new MQTTOutputInteraction(this, brokerUrl, clientName);

        if (trace != null) trace.testExit("createOutputInteraction");
        return newContext;
    }

    @Override
    public void terminate() throws MbException {
        if (trace != null) {
            trace.testEntry("terminate");
            trace.terminate();
        }
    }

    @Override
    public String[] listAdminObjectTypes() throws MbException {
        if (trace != null) trace.testEntry("listAdminObjectTypes");
        if (trace != null) trace.testExit("listAdminObjectTypes");
        return ADMINTYPES;
    }

    @Override
    public String[] listAdminObjectsForType(String adminObjectType) throws MbException {
        if (trace != null) trace.testEntry("listAdminObjectsForType");
        String[] returnValue = null;
        
        if (adminObjectType.equals("Connections")) {
            OutputInteraction[] interactions = getInteractions();
            returnValue = new String[interactions.length];
            for (int i = 0; i < interactions.length; i++) {
                returnValue[i] = ((MQTTOutputInteraction) interactions[i])
                        .getClient().getClientId();
            }
        }
        if (trace != null) trace.testExit("listAdminObjectsForType");
        return returnValue;
    }

    @Override
    public Properties listAdminObjectProperties(String adminObjectType, String adminObjectName) throws MbException {
        if (trace != null) trace.testEntry("listAdminObjectProperties");

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
            properties.put("isConnected", clientName.getClient().isConnected());
            properties.put("serverURI", clientName.getClient().getServerURI());
            properties.put("numberOfPendingDeliveryTokens", clientName
                    .getClient().getPendingDeliveryTokens().length);
        }
        if (trace != null) trace.testExit("listAdminObjectProperties");
        return properties;
    }

    @Override
    public void changeAdminObject(String function, 
                                  Properties newProperties, 
                                  String adminObjectType, 
                                  String adminObjectName) throws MbException 
    {
        if (trace != null) trace.testEntry("changeAdminObject");
        
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
        if (trace != null) trace.testExit("changeAdminObject");
    }

    @Override
    public String adminKey() throws MbException {
        if (trace != null) trace.testEntry("adminKey");
        if (trace != null) trace.testExit("adminKey");
        return null;
    }

    @Override
    public void initialize() throws MbException {
        if (trace != null) trace.testEntry("initialize");
        brokerUrl = getProperties().getProperty("brokerUrl");
        if (brokerUrl == null) {
            brokerUrl = MQTTConnectorFactory.DEFAULT_MQTT_URL;
        }
        brokerUrl = brokerUrl.trim();
        brokerUrl = brokerUrl.toLowerCase();
        if (brokerUrl.startsWith("tcp://") == false) {
            getConnectorFactory().getContainerServices().throwMbRecoverableException("2111",new String[] { "not a tcp:// url" });
        }
        String portNumber = brokerUrl.substring(6);
        int startOfPort = portNumber.indexOf(":");
        if (startOfPort > -1 && startOfPort < portNumber.length() - 2) {
            portNumber = portNumber.substring(startOfPort + 1);
        }
        try {
            Integer.parseInt(portNumber);
        }
        catch (NumberFormatException e) {
            getConnectorFactory().getContainerServices().throwMbRecoverableException("2112",new String[] { "not a valid integer", portNumber });
        }
        if (trace != null) trace.testExit("initialize");
    }
}
