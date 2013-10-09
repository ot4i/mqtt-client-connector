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

import java.util.Properties;

import com.ibm.broker.connector.ConnectorFactory;
import com.ibm.broker.connector.EventInputConnector;
import com.ibm.broker.connector.OutputConnector;
import com.ibm.broker.plugin.MbException;

public class MQTTConnectorFactory extends ConnectorFactory {
    public static final String copyright = Copyright.LONG;
    
    public static final String DEFAULT_MQTT_URL = "tcp://m2m.eclipse.org:1883";
    
    public MQTTTrace trace = null;

    @Override
    public String getInfo() throws MbException {
        if(trace != null)trace.testEntry("getInfo");
        if(trace != null)trace.testExit("getInfo");
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
         // Initialise the trace object
        trace = new MQTTTrace(this, providerProps);
        
        if(trace != null)trace.testEntry("initialize");
        
        String tracePropertiesData = "";
        for(String key : providerProps.stringPropertyNames()){
            if(!tracePropertiesData.equals("")){
                tracePropertiesData += ",";
            }
            tracePropertiesData += key+"="+providerProps.getProperty(key);
        }
        if(trace != null)trace.traceData("initialize", tracePropertiesData);
        if(trace != null)trace.testExit("initialize");
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
        if(trace != null)trace.testEntry("createOutputConnector");
        
        // Set the default MQTT port if one has not been provided.
        if(nodeProps.getProperty("brokerUrl") == null){
            nodeProps.put("brokerUrl", DEFAULT_MQTT_URL);
        }
        
        if(trace != null)trace.testExit("createOutputConnector");
        return new MQTTOutputConnector(this,name, nodeProps);  
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
        if(trace != null)trace.testEntry("createEventInputConnector");
        
        // Set the default MQTT port if one has not been provided.
        if(nodeProps.getProperty("brokerUrl") == null){
            nodeProps.put("brokerUrl", MQTTConnectorFactory.DEFAULT_MQTT_URL);
        }
        
        if(trace != null)trace.testExit("createEventInputConnector");
        return new MQTTInputConnector(this,name, nodeProps); 
    }

    /**
     * This method is a no-op, but would allow you to perform general initialisation
     * for the whole resource manager, regardless of the number of input/output connectors.
     */
    @Override    
    public void start() throws MbException {
        if(trace != null)trace.testEntry("start");
        if(trace != null)trace.testExit("start");
    }

    /**
     * This method is a no-op, but would allow you to perform shutdown logic for the resource
     * once all connectors have stopped.
     */
    @Override
    public void stop() throws MbException {
        if(trace != null)trace.testEntry("stop");
        if(trace != null)trace.testExit("stop");
    }

    /**
     * This method is called when the integration server is about to stop.
     */
    @Override
    public void terminate() throws MbException {
        if(trace != null){
            trace.testEntry("terminate");
            trace.terminate();
            trace = null;
        }
    } 
}
