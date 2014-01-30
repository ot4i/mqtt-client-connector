#MQTT Connector Sample
The MQTT connector sample demonstrates how to integrate an MQTT client application or device with other technologies. The sample includes a simple Java application that simulates a blood pressure monitor, and a message flow that perform content-based routing. The message flow subscribes to the messages published by the blood pressure monitor application and, depending on the message content, publishes blood pressure monitor readings to different topics.

##Running the sample
This sample invokes the Paho Sample.java application with three different run configuration files; two subscribers (one for the hypertension alert monitor, and one for the hypertension emergency monitor), and a publishing client that can be configured to send messages containing blood pressure monitor readings.

1. Deploy and run the MQTT sample in the Integration Toolkit:
  * In the Package Explorer view of the Java perspective, drag the MQTTSample project onto the integration server under the integration node **IB9NODE** in the Integration Nodes view. If you ran the Default Configuration wizard, the integration server is called **default**.
  * Locate the org.eclipse.paho.sample.mqttv3app project, right-click **Sample.java**, select **Run As > Java Application** and choose the appropriate run configuration. 
      * To run the alert subscriber, select **MqttSubscriber_BloodPressureMonitor_HyperTensionAlert**.
      * To run the emergency subscriber, select **MqttSubscriber_BloodPressureMonitor_HyperTensionEmergency**.
      * To run the publisher, select **MqttPublisher_BloodPressureMonitor**.
2. To see the messages appearing on the alert and emergency topics, change the **MqttPublisher_BloodPressureMonitor** run configuration to send different values in the published message.
  * To generate an alert message, the Systolic value must be >= 140 & < 180, and the Diastolic value must be >= 0 & < 110.
  * To generate an emergency message, the Systolic value must be >= 180 and the Diastolic value must be >= 110.
3. Check the Console view to see the program output. 

##Copyright and license
Copyright 2013 IBM Corp. under the [Eclipse Public license](http://www.eclipse.org/legal/epl-v10.html).
