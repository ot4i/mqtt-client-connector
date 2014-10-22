//***************************************************************
//
// Source File Name: MQTTConnectorFactory
//
// Description: This file contains the MQTTConnectorFactory class.
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

import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.ibm.broker.connector.ConnectorFactory;
import com.ibm.broker.connector.EventInputConnector;
import com.ibm.broker.connector.OutputConnector;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbRecoverableException;

public class MQTTConnectorFactory extends ConnectorFactory {
    public static final String copyright = Copyright.LONG;
    
    public static final String DEFAULT_HOST = "";
    public static final String DEFAULT_PORT = "1883";
    public static final String DEFAULT_MQTT_URL = "tcp://" + DEFAULT_HOST + ":" + DEFAULT_PORT;
    public static final String DEFAULT_QOS = "0";
    private static final String clsName = MQTTConnectorFactory.class.getName();
    
    private boolean useBuildMode = false;
	boolean changeAdminToActivityLog = false;
	private MqttClientPersistence cp = null;
    
    @Override
    public String getInfo() throws MbException {
        writeServiceTraceEntry(clsName, "getInfo", "Entry");
        writeServiceTraceExit(clsName, "getInfo", "Exit");
        return "MQTT provider v1.1";
    }
    
    /**
     * This is called by the integration node when an integration server is started up.
     * Any general messaging provider initialization should be done at this point.
     * It is not recommended to do any connections at this point to external systems, just validate that the properties being used are valid.
     * This method is the pair to the "terminate" method.
     * @param name name of the connector factory as defined in the ConnectorProviders configurable service
     * @param properties the properties defined on the ConnectorProviders configurable service
     * @throws MbException Throwing an exception will stop the ConnectionFactory being available for use. 
     */
    @Override
    public void initialize(String providerName, Properties providerProps) throws MbException {
        writeServiceTraceEntry(clsName, "initialize", "Entry");
        try {
			writeServiceTraceData(clsName, "initialize",
					"Connector properties: " + providerProps.toString());
			if (providerProps.getProperty("property1") != null) {
				useBuildMode = providerProps.getProperty("property1")
						.equalsIgnoreCase("useBuildMode");
				changeAdminToActivityLog = providerProps.getProperty(
						"property1").equalsIgnoreCase(
						"changeAdminToActivityLog");
			}
			
			if ("file".equalsIgnoreCase(providerProps.getProperty("property2"))) {
				String cpDir = getContainerServices().getWorkDirectory()
					+ getContainerServices().getFileSeparator()
					+ getContainerServices().containerName();
				cp = new MqttDefaultFilePersistence(cpDir);
			}
			
			else {
				cp = new MemoryPersistence();
			}
		} finally {
			writeServiceTraceExit(clsName, "initialize", "Exit");
		}
    }
    
	public MqttClientPersistence getClientPersistence() {
    	return cp;
    }
    
    /**
     * This is called by the integration node when a connector to send data to the system is required.
     * @param name name of the connector based on the flow and node being used
     * @param properties the properties defined on the node creating the connector
     * @return <A HREF="OutputConnector.html"> OutputConnector</A> 
     * @throws MbException Throwing an exception will fail the creation of the flow requesting the connector.
     */
    @Override
    public OutputConnector createOutputConnector(String name, Properties nodeProps) throws MbException {
        writeServiceTraceEntry(clsName, "createOutputConnector", "Entry");
        try {
			writeServiceTraceData(clsName, "createOutputConnector",
					"Output node properties: " + nodeProps.toString());
			return new MQTTOutputConnector(this, name, nodeProps);
		} finally {
			writeServiceTraceExit(clsName, "createOutputConnector", "Exit");
		}  
    }
    
    /**
     * This is called by the integration node when a connector to receive data from the system is required.
     * @param name name of the connector based on the flow and node being used
     * @param properties the properties defined on the node creating the connector
     * @return <A HREF="EventInputConnector.html"> EventInputConnector.</A> 
     * @throws MbException Throwing an exception will fail the creation of the flow requesting the connector.
     */
    @Override
    public EventInputConnector createEventInputConnector(String name, Properties nodeProps) throws MbException {
        writeServiceTraceEntry(clsName, "createEventInputConnector", "Entry");
        try {
			writeServiceTraceData(clsName, "createEventInputConnector",
					"Input node properties: " + nodeProps.toString());
			return new MQTTInputConnector(this, name, nodeProps);
		} finally {
			writeServiceTraceExit(clsName, "createEventInputConnector", "Exit");
		} 
    }

    /**
     * This method is a no-op, but would allow you to perform general initialisation
     * for the whole resource manager, regardless of the number of input/output connectors.
     */
    @Override    
    public void start() throws MbException {
        writeServiceTraceEntry(clsName, "start", "Entry");
        writeServiceTraceExit(clsName, "start", "Exit");
    }

    /**
     * This method is a no-op, but would allow you to perform shutdown logic for the resource
     * once all connectors have stopped.
     */
    @Override
    public void stop() throws MbException {
        writeServiceTraceEntry(clsName, "stop", "Entry");
        writeServiceTraceExit(clsName, "stop", "Exit");
    }

    /**
     * This method is called when the integration server is about to stop.
     */
    @Override
    public void terminate() throws MbException {
        writeServiceTraceEntry(clsName, "terminate", "Entry");
        writeServiceTraceExit(clsName, "terminate", "Exit");
    } 
    
	public boolean isUseBuildMode() {
		return useBuildMode;
	}

	public String getConnectionURL(Properties props) throws MbException, MbRecoverableException {
        writeServiceTraceExit(clsName, "getConnectionURL", "Exit");
		// Handle any 'connectionUrl' property for backward compatibility 
		String connectionUrl = DEFAULT_MQTT_URL;
		
		if (props.containsKey("hostName")) {
			String host = props.getProperty("hostName");
			String port = props.getProperty("port", MQTTConnectorFactory.DEFAULT_PORT);
			try {
				Integer.parseInt(port);
			} catch (NumberFormatException e) {
				getContainerServices().throwMbRecoverableException(
					"2112",	new String[] { "not a valid integer", port });
			}
			
			connectionUrl = "tcp://" + host + ":" + port;
		}
		else {
			connectionUrl = props.getProperty("connectionUrl", props.getProperty("brokerUrl", DEFAULT_MQTT_URL));
			// Tidy up the URL
			connectionUrl = connectionUrl.trim().toLowerCase();
			if (!connectionUrl.startsWith("tcp://")) {
				getContainerServices().throwMbRecoverableException(
					"2111", new String[] { "not a tcp:// url" });
			}
			int colon = connectionUrl.indexOf(':', 6);
			if (colon > -1) {
				String portNumber = connectionUrl.substring(colon+1);
				try {
					Integer.parseInt(portNumber);
				} catch (NumberFormatException e) {
					getContainerServices().throwMbRecoverableException(
						"2112",	new String[] { "not a valid integer", portNumber });
				}
			}
		}
		
		/* 
		 * If tcp://:1883 is passed to Paho it defaults to localhost, so we need a specific
		 * incorrect hostname that will be obvious to the user that they have not entered one correctly. 
		 */ 
		if(connectionUrl.equals("tcp://:1883"))
		{
			connectionUrl = "tcp://HOSTNAME_NOT_PROVIDED:1883";
		}
		
		writeServiceTraceData(clsName, "getConnectionURL", "MQTT Connection URL: " + connectionUrl);
		props.put("connectionUrl", connectionUrl);
        writeServiceTraceExit(clsName, "getConnectionURL", "Exit");
		return connectionUrl;
	}
}
