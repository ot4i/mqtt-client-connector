mqtt-client-connector
=====================

The MQTT connector enables you to extend the capability of IBM Integration Bus (IIB) to connect to an MQTT server. [IIB](http://www.ibm.com/software/products/us/en/integration-bus/) is available free of charge for developers. This repository includes nodes that allow you to publish and subscribe to topics on an MQTT server from a message flow, and a sample to demonstrate this. 

##Dependencies
Install [IBM Integration Bus Developer Edition](http://www.ibm.com/software/products/us/en/integration-bus/).

To avoid having to manually import the projects into the Integration Toolkit, install the EGit client. A specific version of the client is needed, see [additional instructions](INSTRUCTIONS.md).

##Setup
1. Import the MQTT Client Connector project and its prerequisites. (For instructions on how to download and import the source from GitHub see [additional instructions](INSTRUCTIONS.md))
  * Click "Download ZIP" on the right of [this](https://github.com/ot4i/mqtt-client-connector) page and import the archive file (selecting all the projects) into your Integration Toolkit workspace.
  * Download the Paho Java client [v0.1](http://git.eclipse.org/c/paho/org.eclipse.paho.mqtt.java.git/snapshot/org.eclipse.paho.mqtt.java-0.1.zip) or download the appropriate v0.1 archive file for your platform from the [Eclipse Paho page](http://git.eclipse.org/c/paho/org.eclipse.paho.mqtt.java.git/).

2. Add the nodes to the Integration Toolkit:
  * Clean all projects by clicking **Project** on the menu bar, and selecting **Clean...**.
  * If IIB was not installed in the default location, right-click the MQTTConnector project and select **Build Path**, followed by  **Configure Build Path**. In the **Libraries** tab, update the location of jplugin2.jar and connectors.jar to the classes folder of your IIB runtime installation. The default location of the classes folder on Windows is C:\Program Files\IBM\MQSI\9.0.0.0\classes. 
  * In the Application Development view of the Integration Development perspective, right-click the Independent Resource **MQTTNodes** and select **Start Simulation**. The MQTTNodes resource is now accessible to the Integration Toolkit.

3. Install the connector on IIB:
  * Export the MQTTConnector and the org.eclipse.paho.client.mqttv3 projects as separate jar files, with the same names as the projects, into your file system's *ConnectorRuntimeDirectory*, e.g. C:\Connectors\MQTT.
  * Ensure you have [created a default configuration](http://pic.dhe.ibm.com/infocenter/wmbhelp/v9r0m0/topic/com.ibm.etools.mft.doc/ae20200_.htm).
  * In the WebSphere MQ Explorer, under integration node *IB9NODE*, right-click **Configurable Services** and select **Import *.configurableservice** to import the mqtt.configurableservice from the MQTTSetupForIIB project. Note, if you do not see a Configurable Services option, ensure your integration node is connected (right-click and select **Connect**).
  * Restart integration node *IB9NODE*.

##Platforms
Tested on Windows 7 Pro N x64 with [IIB Developer Edition](http://www.ibm.com/software/products/us/en/integration-bus/).

##Copyright and license
Copyright 2013 IBM Corp. under the [Eclipse Public license](http://www.eclipse.org/legal/epl-v10.html).
