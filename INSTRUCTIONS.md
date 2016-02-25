#MQTT Connector - Additional Instructions

##Download EGit v1.3
In the Integration Toolkit, select **Help > Install New Software**, and enter the URL http://download.eclipse.org/egit/updates-1.3 in the **Work with** field. Select **Eclipse Git Team Provider**, click **Next**, and select only **Eclipse EGit** from the list of options. Note, the Mylyn option must not be selected.

##Clone the Git repositories and import the projects - detailed instructions
In the Integration Toolkit, import the Git repositories and set up IIB:

* In the Git Repository Exploring perspective, click **Clone a Git repository**.
* Clone the Eclipse Paho project by setting the git repository URI to https://git.eclipse.org/gitroot/paho/org.eclipse.paho.mqtt.java.git
* Select the master branch.
* In the Git Repositories view, expand the Tags section, and right-click the v0.1 tagged branch of the Eclipse Paho project to check it out.
* Import the Eclipse Paho project into your workspace (in the Git Repositories view, under org.eclipse.paho.mqtt.java, right-click Working Directory and select **Import Projects**). 
* In the Git Repositories view, click the **Clone a Git Repository** icon on the toolbar at the top right of the window.
* Clone and import the projects:
  * Set the git repository URI to https://github.com/ot4i/mqtt-client-connector.git
   
  * Click Next, and select the master branch.
  * Click Next, and set a local destination.
  * Select the option **Import all existing projects after clone finishes**, and click Finish. 

##Copyright and license
Copyright 2013 IBM Corp. under the [Eclipse Public license](http://www.eclipse.org/legal/epl-v10.html).
