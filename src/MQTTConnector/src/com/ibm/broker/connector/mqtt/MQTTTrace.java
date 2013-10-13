package com.ibm.broker.connector.mqtt;

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


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.ibm.broker.connector.ConnectorFactory;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbRecoverableException;

public class MQTTTrace {
	public static final String copyright = Copyright.LONG;
	   
	boolean traceOn = false;
	File traceFile = null;
	FileOutputStream fos = null;
	boolean useBuildMode = false;
	boolean changeAdminToActivityLog = false;
	ConnectorFactory mqttConnectorFactory = null;

	public MQTTTrace(ConnectorFactory mqttConnectorFactory, Properties providerProps) throws MbRecoverableException {
	    this.mqttConnectorFactory = mqttConnectorFactory;
		setupTrace(providerProps);
		setupException(providerProps);
	}

	public void testEntry(String methodName) throws MbException {
		if (traceOn) {
			try {
				fos.write(("***ENTRY>" + methodName + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void testExit(String methodName) {
		if (traceOn) {
			try {
				fos.write(("***EXIT<" + methodName + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void traceData(String methodName, String data) {
		if (traceOn) {
			try {
				fos.write(("***" + methodName + ">" + data + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void setupTrace(Properties providerProps) throws MbRecoverableException {
		if (providerProps.getProperty("property1") != null) {
			if (providerProps.getProperty("property1").equalsIgnoreCase(
					"traceon")) {
				traceOn = true;
				if (providerProps.getProperty("property2") != null) {
					traceFile = new File(providerProps.getProperty("property2"));
					if (!traceFile.exists()) {
						new File(traceFile.getParent()).mkdirs();
						try {
							traceFile.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					try {
						fos = new FileOutputStream(traceFile, true);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						mqttConnectorFactory.getContainerServices().throwMbRecoverableException(e);
					}
				}
			}
		}
	}

	private void setupException(Properties providerProps) {
		if (providerProps!= null && providerProps.getProperty("property3") != null) {
			if (providerProps.getProperty("property3").equalsIgnoreCase(
					"useBuildMode")) {
				useBuildMode = true;
			} else if (providerProps.getProperty("property3").equalsIgnoreCase(
					"changeAdminToActivityLog")) {
				changeAdminToActivityLog = true;
			}
		}
	}

	public void terminate() {
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isUseBuildMode() {
		return useBuildMode;
	}

}
