package com.ibm.connector.mqtt;

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>MQTTPublishNodeUDN</I> instance</p>
 * <p></p>
 */
public class MQTTPublishNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/connector/mqtt/OutputNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/MQTTNodes/icons/full/obj16/com/ibm/connector/mqtt/ComIbmOutput.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/MQTTNodes/icons/full/obj30/com/ibm/connector/mqtt/ComIbmOutput.gif";

	protected final static String PROPERTY_CLIENTID = "clientId";
	protected final static String PROPERTY_TOPICNAME = "topicName";
	protected final static String PROPERTY_HOSTNAME = "hostName";
	protected final static String PROPERTY_PORT = "port";
	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_VALIDATEMASTER = "validateMaster";
	protected final static String PROPERTY_VALIDATEFAILUREACTION = "validateFailureAction";
	protected final static String PROPERTY_VALIDATEALLVALUECONSTRAINTS = "validateAllValueConstraints";
	protected final static String PROPERTY_VALIDATEFIXUP = "validateFixup";
	protected final static String PROPERTY_SECURITYPROFILENAME = "securityProfileName";


	/**
	 * <I>ENUM_MQTTPUBLISH_VALIDATEMASTER</I>
	 * <pre>
	 * ENUM_MQTTPUBLISH_VALIDATEMASTER.none = None
	 * ENUM_MQTTPUBLISH_VALIDATEMASTER.contentAndValue = Content and Value
	 * ENUM_MQTTPUBLISH_VALIDATEMASTER.content = Content
	 * ENUM_MQTTPUBLISH_VALIDATEMASTER.inherit = Inherit
	 * </pre>
	 */
	public static class ENUM_MQTTPUBLISH_VALIDATEMASTER {
		private String value;

		public static final ENUM_MQTTPUBLISH_VALIDATEMASTER none = new ENUM_MQTTPUBLISH_VALIDATEMASTER("none");
		public static final ENUM_MQTTPUBLISH_VALIDATEMASTER contentAndValue = new ENUM_MQTTPUBLISH_VALIDATEMASTER("contentAndValue");
		public static final ENUM_MQTTPUBLISH_VALIDATEMASTER content = new ENUM_MQTTPUBLISH_VALIDATEMASTER("content");
		public static final ENUM_MQTTPUBLISH_VALIDATEMASTER inherit = new ENUM_MQTTPUBLISH_VALIDATEMASTER("inherit");

		protected ENUM_MQTTPUBLISH_VALIDATEMASTER(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTPUBLISH_VALIDATEMASTER getEnumFromString(String enumValue) {
			ENUM_MQTTPUBLISH_VALIDATEMASTER enumConst = ENUM_MQTTPUBLISH_VALIDATEMASTER.none;
			if (ENUM_MQTTPUBLISH_VALIDATEMASTER.contentAndValue.value.equals(enumValue)) enumConst = ENUM_MQTTPUBLISH_VALIDATEMASTER.contentAndValue;
			if (ENUM_MQTTPUBLISH_VALIDATEMASTER.content.value.equals(enumValue)) enumConst = ENUM_MQTTPUBLISH_VALIDATEMASTER.content;
			if (ENUM_MQTTPUBLISH_VALIDATEMASTER.inherit.value.equals(enumValue)) enumConst = ENUM_MQTTPUBLISH_VALIDATEMASTER.inherit;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "contentAndValue", "content", "inherit" };

	}

	/**
	 * <I>ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION</I>
	 * <pre>
	 * ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.userTrace = User Trace
	 * ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.localError = Local Error Log
	 * ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.exception = Exception
	 * ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.exceptionList = Exception List
	 * </pre>
	 */
	public static class ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION {
		private String value;

		public static final ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION userTrace = new ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION("userTrace");
		public static final ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION localError = new ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION("localError");
		public static final ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION exception = new ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION("exception");
		public static final ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION exceptionList = new ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION("exceptionList");

		protected ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION getEnumFromString(String enumValue) {
			ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION enumConst = ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.userTrace;
			if (ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.localError.value.equals(enumValue)) enumConst = ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.localError;
			if (ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.exception.value.equals(enumValue)) enumConst = ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.exception;
			if (ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.exceptionList.value.equals(enumValue)) enumConst = ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.exceptionList;
			return enumConst;
		}

		public static String[] values = new String[]{ "userTrace", "localError", "exception", "exceptionList" };

	}

	/**
	 * <I>ENUM_MQTTPUBLISH_VALIDATEFIXUP</I>
	 * <pre>
	 * ENUM_MQTTPUBLISH_VALIDATEFIXUP.none = None
	 * ENUM_MQTTPUBLISH_VALIDATEFIXUP.full = Full
	 * </pre>
	 */
	public static class ENUM_MQTTPUBLISH_VALIDATEFIXUP {
		private String value;

		public static final ENUM_MQTTPUBLISH_VALIDATEFIXUP none = new ENUM_MQTTPUBLISH_VALIDATEFIXUP("none");
		public static final ENUM_MQTTPUBLISH_VALIDATEFIXUP full = new ENUM_MQTTPUBLISH_VALIDATEFIXUP("full");

		protected ENUM_MQTTPUBLISH_VALIDATEFIXUP(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTPUBLISH_VALIDATEFIXUP getEnumFromString(String enumValue) {
			ENUM_MQTTPUBLISH_VALIDATEFIXUP enumConst = ENUM_MQTTPUBLISH_VALIDATEFIXUP.none;
			if (ENUM_MQTTPUBLISH_VALIDATEFIXUP.full.value.equals(enumValue)) enumConst = ENUM_MQTTPUBLISH_VALIDATEFIXUP.full;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "full" };

	}
	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_CLIENTID,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_TOPICNAME,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_HOSTNAME,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_PORT,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.INTEGER, "1883","","",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "MQTT","","",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_VALIDATEMASTER,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.ENUMERATION, "inherit", ENUM_MQTTPUBLISH_VALIDATEMASTER.class,"","",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_VALIDATEFAILUREACTION,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "exception", ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.class,"",	"com.ibm.etools.mft.ibmnodes.editors.ValidateMasterListenerPropertyEditor",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.BOOLEAN, "true",	"com.ibm.etools.mft.ibmnodes.compilers.BooleanPropertyCompiler","",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_VALIDATEFIXUP,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTPUBLISH_VALIDATEFIXUP.class,"","",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTPublishNodeUDN.PROPERTY_SECURITYPROFILENAME,		NodeProperty.Usage.OPTIONAL,	true,	NodeProperty.Type.STRING, "","",	"com.ibm.etools.mft.ibmnodes.editors.SecurityProfileNamePropertyEditor",	"com/ibm/connector/mqtt/ComIbmOutput",	"MQTTNodes")
		};
	}

	public MQTTPublishNodeUDN() {
	}

	public final InputTerminal INPUT_TERMINAL_IN = new InputTerminal(this,"InTerminal.in");
	@Override
	public InputTerminal[] getInputTerminals() {
		return new InputTerminal[] {
			INPUT_TERMINAL_IN
	};
	}

	public final OutputTerminal OUTPUT_TERMINAL_FAILURE = new OutputTerminal(this,"OutTerminal.failure");
	public final OutputTerminal OUTPUT_TERMINAL_OUT = new OutputTerminal(this,"OutTerminal.out");
	@Override
	public OutputTerminal[] getOutputTerminals() {
		return new OutputTerminal[] {
			OUTPUT_TERMINAL_FAILURE,
			OUTPUT_TERMINAL_OUT
		};
	}

	@Override
	public String getTypeName() {
		return NODE_TYPE_NAME;
	}

	protected String getGraphic16() {
		return NODE_GRAPHIC_16;
	}

	protected String getGraphic32() {
		return NODE_GRAPHIC_32;
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>Client ID</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Client ID</I>"
	 */
	public MQTTPublishNodeUDN setClientId(String value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_CLIENTID, value);
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> "<I>Client ID</I>" property
	 * 
	 * @return String; the value of the property "<I>Client ID</I>"
	 */
	public String getClientId() {
		return (String)getPropertyValue(MQTTPublishNodeUDN.PROPERTY_CLIENTID);
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>Topic name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Topic name</I>"
	 */
	public MQTTPublishNodeUDN setTopicName(String value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_TOPICNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> "<I>Topic name</I>" property
	 * 
	 * @return String; the value of the property "<I>Topic name</I>"
	 */
	public String getTopicName() {
		return (String)getPropertyValue(MQTTPublishNodeUDN.PROPERTY_TOPICNAME);
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>Host name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Host name</I>"
	 */
	public MQTTPublishNodeUDN setHostName(String value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_HOSTNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> "<I>Host name</I>" property
	 * 
	 * @return String; the value of the property "<I>Host name</I>"
	 */
	public String getHostName() {
		return (String)getPropertyValue(MQTTPublishNodeUDN.PROPERTY_HOSTNAME);
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>Port</I>" property
	 * 
	 * @param value int ; the value to set the property "<I>Port</I>"
	 */
	public MQTTPublishNodeUDN setPort(int value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_PORT, Integer.toString(value));
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> <I>Port</I> property
	 * 
	 * @return int; the value of the property "<I>Port</I>"
	 */
	public int getPort() {
		String value = (String)getPropertyValue(MQTTPublishNodeUDN.PROPERTY_PORT);
		return Integer.valueOf(value).intValue();
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>Connector name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Connector name</I>"
	 */
	public MQTTPublishNodeUDN setConnectorName(String value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> "<I>Connector name</I>" property
	 * 
	 * @return String; the value of the property "<I>Connector name</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(MQTTPublishNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>Validate</I>" property
	 * 
	 * @param value ENUM_MQTTPUBLISH_VALIDATEMASTER ; the value to set the property "<I>Validate</I>"
	 */
	public MQTTPublishNodeUDN setValidateMaster(ENUM_MQTTPUBLISH_VALIDATEMASTER value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_VALIDATEMASTER, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> "<I>Validate</I>" property
	 * 
	 * @return ENUM_MQTTPUBLISH_VALIDATEMASTER; the value of the property "<I>Validate</I>"
	 */
	public ENUM_MQTTPUBLISH_VALIDATEMASTER getValidateMaster() {
		ENUM_MQTTPUBLISH_VALIDATEMASTER value = ENUM_MQTTPUBLISH_VALIDATEMASTER.getEnumFromString((String)getPropertyValue(MQTTPublishNodeUDN.PROPERTY_VALIDATEMASTER));
		return value;
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>Failure action</I>" property
	 * 
	 * @param value ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION ; the value to set the property "<I>Failure action</I>"
	 */
	public MQTTPublishNodeUDN setValidateFailureAction(ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_VALIDATEFAILUREACTION, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> "<I>Failure action</I>" property
	 * 
	 * @return ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION; the value of the property "<I>Failure action</I>"
	 */
	public ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION getValidateFailureAction() {
		ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION value = ENUM_MQTTPUBLISH_VALIDATEFAILUREACTION.getEnumFromString((String)getPropertyValue(MQTTPublishNodeUDN.PROPERTY_VALIDATEFAILUREACTION));
		return value;
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>validateAllValueConstraints</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>validateAllValueConstraints</I>"
	 */
	public MQTTPublishNodeUDN setValidateAllValueConstraints(boolean value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> "<I>validateAllValueConstraints</I>" property
	 * 
	 * @return boolean; the value of the property "<I>validateAllValueConstraints</I>"
	 */
	public boolean getValidateAllValueConstraints(){
	if (getPropertyValue(MQTTPublishNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>validateFixup</I>" property
	 * 
	 * @param value ENUM_MQTTPUBLISH_VALIDATEFIXUP ; the value to set the property "<I>validateFixup</I>"
	 */
	public MQTTPublishNodeUDN setValidateFixup(ENUM_MQTTPUBLISH_VALIDATEFIXUP value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_VALIDATEFIXUP, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> "<I>validateFixup</I>" property
	 * 
	 * @return ENUM_MQTTPUBLISH_VALIDATEFIXUP; the value of the property "<I>validateFixup</I>"
	 */
	public ENUM_MQTTPUBLISH_VALIDATEFIXUP getValidateFixup() {
		ENUM_MQTTPUBLISH_VALIDATEFIXUP value = ENUM_MQTTPUBLISH_VALIDATEFIXUP.getEnumFromString((String)getPropertyValue(MQTTPublishNodeUDN.PROPERTY_VALIDATEFIXUP));
		return value;
	}

	/**
	 * Set the <I>MQTTPublishNodeUDN</I> "<I>securityProfileName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>securityProfileName</I>"
	 */
	public MQTTPublishNodeUDN setSecurityProfileName(String value) {
		setProperty(MQTTPublishNodeUDN.PROPERTY_SECURITYPROFILENAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTPublishNodeUDN</I> "<I>securityProfileName</I>" property
	 * 
	 * @return String; the value of the property "<I>securityProfileName</I>"
	 */
	public String getSecurityProfileName() {
		return (String)getPropertyValue(MQTTPublishNodeUDN.PROPERTY_SECURITYPROFILENAME);
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "MQTT Publish";
		return retVal;
	};
}
