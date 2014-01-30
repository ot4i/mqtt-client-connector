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

import static com.ibm.broker.connector.ContainerServices.writeServiceTraceEntry;
import static com.ibm.broker.connector.ContainerServices.writeServiceTraceExit;

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
    private static final String clsName = MQTTEvent.class.getName();

    MqttMessage message = null;
    MqttTopic topic = null;

    public MQTTInputConnector getMQTTConnector() throws MbException {
        return (MQTTInputConnector) getConnector();
    }

    public MQTTEvent(MqttTopic topic, MqttMessage message)
            throws MbException {
        this.message = message;
        this.topic = topic;
    }

    @Override
    public String eventSource() throws MbException {
        writeServiceTraceEntry(clsName, "eventSource", "Entry");
        writeServiceTraceExit(clsName, "eventSource", "Exit");
        return topic.getName();
    }

    @Override
    public void logEvent() throws MbException {
        writeServiceTraceEntry(clsName, "logEvent", "Entry");
        
        try {
			getConnector().writeActivityLog("12065",
					new String[] { topic.getName() }, // Inserts
					getMQTTConnector().getActivityLogTag()); // Activity Log tags
		} finally {
			writeServiceTraceExit(clsName, "logEvent", "Exit");
		}
    }

    @Override
    public InputRecord buildInputRecord() throws MbException {
        writeServiceTraceEntry(clsName, "buildInputRecord", "Entry");
        try {
			InputRecord inputRecord = null;
			if (getMQTTConnector().getMQTTFactory().isUseBuildMode()) {
				inputRecord = new ElementInputRecord();
				MbElement root = ((ElementInputRecord) inputRecord)
						.getElement();
				MbElement parser = root.createElementAsLastChild("XMLNSC");
				try {
					parser.createElementAsLastChild(MbElement.TYPE_NAME_VALUE,
							"Test", new String(message.getPayload()));
				} catch (MqttException e) {
					getConnector().getConnectorFactory().getContainerServices()
							.throwMbRecoverableException(e);
				}
			} else {
				inputRecord = new ByteArrayInputRecord();
				try {
					((ByteArrayInputRecord) inputRecord)
							.appendByteArray(message.getPayload());
				} catch (MqttException e) {
					getConnector().getConnectorFactory().getContainerServices()
							.throwMbRecoverableException(e);
				}
			}
			return inputRecord;
		} finally {
			writeServiceTraceExit(clsName, "buildInputRecord", "Exit");
		}
    }

    @Override
    public Properties buildProperties() throws MbException {
        writeServiceTraceEntry(clsName, "buildProperties", "Entry");
        
        Properties leValues = new Properties();
        leValues.put("Duplicate", message.isDuplicate());
        leValues.put("Retained", message.isRetained());
        
        writeServiceTraceExit(clsName, "buildProperties", "Exit");
        return leValues;
    }

    @Override
    public void confirm() throws MbException {
        writeServiceTraceEntry(clsName, "confirm", "Entry");
        
        try {
			super.confirm();
		} finally {
			writeServiceTraceExit(clsName, "confirm", "Exit");
		}
    }

}
