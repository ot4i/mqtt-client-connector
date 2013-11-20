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

import java.util.Enumeration;
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
    Properties topicTag = new Properties();
    
    public MQTTTrace trace = null;
    
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
    
    private int qos = 0;
    
    MQTTOutputConnector getMQTTSession() throws MbException{
        return (MQTTOutputConnector)getConnector();
    }
    public MQTTOutputInteraction(OutputConnector connector,String brokerUrl, String clientId) throws MbException{
        super(connector);
        trace = new MQTTTrace(connector.getConnectorFactory(), connector.getProperties());
        topicTag.put("Topic", connector.getProperties().get("topicName"));
        topicTag.put("BrokerUrl", connector.getProperties().get("brokerUrl"));
        String clientNameTrun = null;
        if(clientId.length()>23){
            clientNameTrun = clientId.substring(clientId.length()-23);
        }
        else{
            clientNameTrun = clientId;
        }
        try{
          dataStore = new MqttDefaultFilePersistence(getConnector().getConnectorFactory().getContainerServices().getWorkDirectory()+
                                                     getConnector().getConnectorFactory().getContainerServices().getFileSeparator()+
                                                     clientNameTrun+System.currentTimeMillis());
          client    =  new MqttClient(brokerUrl, clientNameTrun, dataStore);  
          client.connect();
        }
        catch(MqttException e){
              getConnector().writeActivityLog("12067",new String[]{brokerUrl},topicTag );
              getConnector().getConnectorFactory().getContainerServices().throwMbRecoverableException("12067",new String[]{brokerUrl});
        }
        getConnector().writeActivityLog("12063",new String[]{""+getConnector().getProperties().get("brokerUrl")},topicTag );
    }
    
    @Override
    public Properties send(Properties overrideProps, OutputRecord record) throws MbException {
        if(trace != null)trace.testEntry("send");
        Enumeration<Object> keys = overrideProps.keys();
        String tracePropertiesData = "";
        while(keys.hasMoreElements()){
            String key = (String)keys.nextElement();
            if(!tracePropertiesData.equals("")){ 
                tracePropertiesData += ",";
            }
            tracePropertiesData += key+"="+overrideProps.getProperty(key);
        }
        if(trace != null)trace.traceData("send", tracePropertiesData);
        if(!client.isConnected()){
            try {
                client.connect();
            } catch (MqttSecurityException e) {
                  getConnector().writeActivityLog("12067",new String[]{""+getConnector().getProperties().get("brokerUrl")},topicTag );
                  getConnector().getConnectorFactory().getContainerServices().throwMbRecoverableException("12067",new String[]{""+getConnector().getProperties().get("brokerUrl")});
            } catch (MqttException e) {
                  getConnector().writeActivityLog("12067",new String[]{""+getConnector().getProperties().get("brokerUrl")},topicTag );
                  getConnector().getConnectorFactory().getContainerServices().throwMbRecoverableException("12067",new String[]{""+getConnector().getProperties().get("brokerUrl")});
            }
            getConnector().writeActivityLog("12063",new String[]{""+getConnector().getProperties().get("brokerUrl")},topicTag );
        }

        String overrideTopic = overrideProps.getProperty("TopicName");
        if(overrideTopic == null){
            topicName = getConnector().getProperties().getProperty("topicName");
        }
        else{
            topicName = overrideTopic;
        }
        String qosStr = overrideProps.getProperty("qualityOfService");
        if(qosStr == null || qosStr.length() == 0){
        	qosStr = getConnector().getProperties().getProperty("qualityOfService");
        }
        if(qosStr == null || "atMostOnce".equals(qosStr)) {
        	qos = 0;
        } else if("atLeastOnce".equals(qosStr)) {
        	qos = 1;
        } else if("exactlyOnce".equals(qosStr)) {
        	qos = 2;
        } else {
    		getConnector().getConnectorFactory().getContainerServices().throwMbRecoverableException("2111", new String[]{"Invalid QoS: " + qosStr});       		
    	}
        
        MqttTopic topic = client.getTopic(topicName);
        // Construct the message to publish
        MqttMessage message = new MqttMessage(record.getByteData());
        message.setQos(qos);
        
        MqttDeliveryToken token = null;
        try {
            token = topic.publish(message);
            if(trace != null)trace.traceData("send",record.getUTF8Data());
            token.waitForCompletion();
        } catch (MqttPersistenceException e) {
            getConnector().getConnectorFactory().getContainerServices().throwMbRecoverableException(e);
        } catch (MqttException e) {
            getConnector().getConnectorFactory().getContainerServices().throwMbRecoverableException(e);
        }

        Properties returnProperties = new Properties();
        if(token != null){
          returnProperties.put("DeliveryToken/isComplete", token.isComplete());
        }
        returnProperties.put("ClientId", client.getClientId());
        if(trace != null)trace.testExit("send");
        return returnProperties;
    }
    
    @Override
    public String sentDestination(){
        return topicName;
    }

    @Override
    public void terminate() throws MbException {
        if(trace != null)trace.testEntry("terminate");
        try {
            client.disconnect();
            dataStore.clear();
            dataStore.close();
        } catch (MqttException e) {
            getConnector().getConnectorFactory().getContainerServices().throwMbRecoverableException(e);
        }
        if(trace != null)trace.terminate();
    }
}
