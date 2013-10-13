mqtt-client-connector
=====================

The MQTT connector enables you to extend the capability of IBM Integration Bus (IIB) to connect to an MQTT server. [IIB](http://www.ibm.com/software/products/us/en/integration-bus/) is available free of charge for developers. This repository includes nodes that allow you to publish and subscribe to topics on an MQTT server from a message flow, and a sample to demonstrate this. 

##Dependencies
Install [IBM Integration Bus Developer Edition](http://www.ibm.com/software/products/us/en/integration-bus/).

To avoid having to manually import the projects into the Integration Toolkit, install the EGit client. A specific version of the client is needed, see [additional instructions](INSTRUCTIONS.md).

##Setup
1. Clone the Git repositories and import the projects (see [additional instructions](INSTRUCTIONS.md) if you need more detailed instructions):
  * Clone the Eclipse Paho project
    ``` git clone git://git.eclipse.org/gitroot/paho/org.eclipse.paho.mqtt.java.git ```
  * Check out Paho v0.1
    ``` git checkout tags/v0.1 ```
  * Import the Paho projects into your Eclipse workspace 
  * Clone this git repository
    ``` git clone git://github.com/ot4i/mqtt-client-connector.git ```
  * Import the MQTTConnector, MQTTNodes and MQTTSetupForIIB projects into your Eclipse workspace
 
2. Add the nodes to the Integration Toolkit:
  * Clean all projects by clicking **Project** on the menu bar, and selecting **Clean...**.
  * If IIB was not installed in the default location, right-click the MQTTConnector project and select **Build Path**, followed by  **Configure Build Path**. In the **Libraries** tab, update the location of jplugin2.jar and connectors.jar to the classes folder of your IIB runtime installation. The default location of the classes folder on Windows is C:\Program Files\IBM\MQSI\9.0.0.0\classes. 
  * In the MQTTNodes project, remove the package declaration 'package ComIbm;' from the start of the two files MQTTInputNodeUDN.java and MQTTOutputNodeUDN.java. Note, every time a full build is run or the user defined node project is built, the package declaration will need to be removed from these files. You will need to switch to the Java perspective to see these files in the package explorer. Alternatively, you can double click on the errors in the problems view to open these files for editing.
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
