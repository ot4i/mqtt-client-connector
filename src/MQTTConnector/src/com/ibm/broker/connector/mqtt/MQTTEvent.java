//***************************************************************
//
// Source File Name: MQTTEvent
//
// Description: This file contains the MQTTEvent class.
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
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

import com.ibm.broker.connector.ByteArrayInputRecord;
import com.ibm.broker.connector.ElementInputRecord;
import com.ibm.broker.connector.Event;
import com.ibm.broker.connector.InputRecord;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;

public class MQTTEvent extends Event {
    public static final String copyright = Copyright.LONG;

    MqttMessage message = null;
    MqttTopic topic = null;
    MQTTTrace trace;

    public MQTTInputConnector getMQTTConnector() throws MbException {
        return (MQTTInputConnector) getConnector();
    }

    public MQTTEvent(MqttTopic topic, MqttMessage message, MQTTTrace unitTester)
            throws MbException {
        this.message = message;
        this.topic = topic;
        this.trace = unitTester;
    }

    @Override
    public String eventSource() throws MbException {
        if (trace != null) trace.testEntry("eventSource");
        if (trace != null) trace.testExit("eventSource");
        return topic.getName();
    }

    @Override
    public void logEvent() throws MbException {
        if (trace != null) trace.testEntry("logEvent");
        
        getConnector().writeActivityLog("12065", 
                new String[] { topic.getName() },           // Inserts
                getMQTTConnector().getActivityLogTag());    // Activity Log tags
        
        if (trace != null) trace.testExit("logEvent");
    }

    @Override
    public InputRecord buildInputRecord() throws MbException {
        if (trace != null) trace.testEntry("buildInputRecord");
        InputRecord inputRecord = null;
        
        if (trace != null && trace.isUseBuildMode() == true) {
            inputRecord = new ElementInputRecord();
            MbElement root = ((ElementInputRecord) inputRecord).getElement();
            MbElement parser = root.createElementAsLastChild("XMLNSC");
            try {
                parser.createElementAsLastChild(MbElement.TYPE_NAME_VALUE,
                        "Test", new String(message.getPayload()));
            }
            catch (MqttException e) {
                getConnector().getConnectorFactory().getContainerServices()
                        .throwMbRecoverableException(e);
            }
        } else {
            inputRecord = new ByteArrayInputRecord();
            try {
                ((ByteArrayInputRecord) inputRecord).appendByteArray(message
                        .getPayload());
            }
            catch (MqttException e) {
                getConnector().getConnectorFactory().getContainerServices()
                        .throwMbRecoverableException(e);
            }
        }
        if (trace != null) trace.testExit("buildInputRecord");
        return inputRecord;
    }

    @Override
    public Properties buildProperties() throws MbException {
        if (trace != null) trace.testEntry("buildProperties");
        
        Properties leValues = new Properties();
        leValues.put("Duplicate", message.isDuplicate());
        leValues.put("Retained", message.isRetained());
        
        if (trace != null) trace.testExit("buildProperties");
        return leValues;
    }

    @Override
    public void confirm() throws MbException {
        if (trace != null) trace.testEntry("confirm");
        
        super.confirm();
        
        if (trace != null) trace.testExit("confirm");
    }

}
