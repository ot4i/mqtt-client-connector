import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>MQTTOutputNodeUDN</I> instance</p>
 * <p></p>
 */
public class MQTTOutputNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "OutputNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/MQTTNodes/icons/full/obj16/ComIbmOutput.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/MQTTNodes/icons/full/obj30/ComIbmOutput.gif";

	protected final static String PROPERTY_CLIENTID = "clientId";
	protected final static String PROPERTY_TOPICNAME = "topicName";
	protected final static String PROPERTY_BROKERURL = "brokerUrl";
	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_VALIDATEMASTER = "validateMaster";
	protected final static String PROPERTY_VALIDATEFAILUREACTION = "validateFailureAction";
	protected final static String PROPERTY_VALIDATEALLVALUECONSTRAINTS = "validateAllValueConstraints";
	protected final static String PROPERTY_VALIDATEFIXUP = "validateFixup";
	protected final static String PROPERTY_SECURITYPROFILENAME = "securityProfileName";


	/**
	 * <I>ENUM_MQTTOUTPUT_VALIDATEMASTER</I>
	 * <pre>
	 * ENUM_MQTTOUTPUT_VALIDATEMASTER.none = None
	 * ENUM_MQTTOUTPUT_VALIDATEMASTER.contentAndValue = Content and Value
	 * ENUM_MQTTOUTPUT_VALIDATEMASTER.content = Content
	 * ENUM_MQTTOUTPUT_VALIDATEMASTER.inherit = Inherit
	 * </pre>
	 */
	public static class ENUM_MQTTOUTPUT_VALIDATEMASTER {
		private String value;

		public static final ENUM_MQTTOUTPUT_VALIDATEMASTER none = new ENUM_MQTTOUTPUT_VALIDATEMASTER("none");
		public static final ENUM_MQTTOUTPUT_VALIDATEMASTER contentAndValue = new ENUM_MQTTOUTPUT_VALIDATEMASTER("contentAndValue");
		public static final ENUM_MQTTOUTPUT_VALIDATEMASTER content = new ENUM_MQTTOUTPUT_VALIDATEMASTER("content");
		public static final ENUM_MQTTOUTPUT_VALIDATEMASTER inherit = new ENUM_MQTTOUTPUT_VALIDATEMASTER("inherit");

		protected ENUM_MQTTOUTPUT_VALIDATEMASTER(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTOUTPUT_VALIDATEMASTER getEnumFromString(String enumValue) {
			ENUM_MQTTOUTPUT_VALIDATEMASTER enumConst = ENUM_MQTTOUTPUT_VALIDATEMASTER.none;
			if (ENUM_MQTTOUTPUT_VALIDATEMASTER.contentAndValue.value.equals(enumValue)) enumConst = ENUM_MQTTOUTPUT_VALIDATEMASTER.contentAndValue;
			if (ENUM_MQTTOUTPUT_VALIDATEMASTER.content.value.equals(enumValue)) enumConst = ENUM_MQTTOUTPUT_VALIDATEMASTER.content;
			if (ENUM_MQTTOUTPUT_VALIDATEMASTER.inherit.value.equals(enumValue)) enumConst = ENUM_MQTTOUTPUT_VALIDATEMASTER.inherit;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "contentAndValue", "content", "inherit" };

	}

	/**
	 * <I>ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION</I>
	 * <pre>
	 * ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.userTrace = User Trace
	 * ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.localError = Local Error Log
	 * ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.exception = Exception
	 * ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.exceptionList = Exception List
	 * </pre>
	 */
	public static class ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION {
		private String value;

		public static final ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION userTrace = new ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION("userTrace");
		public static final ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION localError = new ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION("localError");
		public static final ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION exception = new ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION("exception");
		public static final ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION exceptionList = new ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION("exceptionList");

		protected ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION getEnumFromString(String enumValue) {
			ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION enumConst = ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.userTrace;
			if (ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.localError.value.equals(enumValue)) enumConst = ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.localError;
			if (ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.exception.value.equals(enumValue)) enumConst = ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.exception;
			if (ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.exceptionList.value.equals(enumValue)) enumConst = ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.exceptionList;
			return enumConst;
		}

		public static String[] values = new String[]{ "userTrace", "localError", "exception", "exceptionList" };

	}

	/**
	 * <I>ENUM_MQTTOUTPUT_VALIDATEFIXUP</I>
	 * <pre>
	 * ENUM_MQTTOUTPUT_VALIDATEFIXUP.none = None
	 * ENUM_MQTTOUTPUT_VALIDATEFIXUP.full = Full
	 * </pre>
	 */
	public static class ENUM_MQTTOUTPUT_VALIDATEFIXUP {
		private String value;

		public static final ENUM_MQTTOUTPUT_VALIDATEFIXUP none = new ENUM_MQTTOUTPUT_VALIDATEFIXUP("none");
		public static final ENUM_MQTTOUTPUT_VALIDATEFIXUP full = new ENUM_MQTTOUTPUT_VALIDATEFIXUP("full");

		protected ENUM_MQTTOUTPUT_VALIDATEFIXUP(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTOUTPUT_VALIDATEFIXUP getEnumFromString(String enumValue) {
			ENUM_MQTTOUTPUT_VALIDATEFIXUP enumConst = ENUM_MQTTOUTPUT_VALIDATEFIXUP.none;
			if (ENUM_MQTTOUTPUT_VALIDATEFIXUP.full.value.equals(enumValue)) enumConst = ENUM_MQTTOUTPUT_VALIDATEFIXUP.full;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "full" };

	}
	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(MQTTOutputNodeUDN.PROPERTY_CLIENTID,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTOutputNodeUDN.PROPERTY_TOPICNAME,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTOutputNodeUDN.PROPERTY_BROKERURL,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTOutputNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "MQTT","","",	"ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTOutputNodeUDN.PROPERTY_VALIDATEMASTER,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.ENUMERATION, "inherit", ENUM_MQTTOUTPUT_VALIDATEMASTER.class,"","",	"ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTOutputNodeUDN.PROPERTY_VALIDATEFAILUREACTION,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "exception", ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.class,"",	"com.ibm.etools.mft.ibmnodes.editors.ValidateMasterListenerPropertyEditor",	"ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTOutputNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.BOOLEAN, "true",	"com.ibm.etools.mft.ibmnodes.compilers.BooleanPropertyCompiler","",	"ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTOutputNodeUDN.PROPERTY_VALIDATEFIXUP,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTOUTPUT_VALIDATEFIXUP.class,"","",	"ComIbmOutput",	"MQTTNodes"),
			new NodeProperty(MQTTOutputNodeUDN.PROPERTY_SECURITYPROFILENAME,		NodeProperty.Usage.OPTIONAL,	true,	NodeProperty.Type.STRING, "","",	"com.ibm.etools.mft.ibmnodes.editors.SecurityProfileNamePropertyEditor",	"ComIbmOutput",	"MQTTNodes")
		};
	}

	public MQTTOutputNodeUDN() {
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
	 * Set the <I>MQTTOutputNodeUDN</I> "<I>Client ID</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Client ID</I>"
	 */
	public MQTTOutputNodeUDN setClientId(String value) {
		setProperty(MQTTOutputNodeUDN.PROPERTY_CLIENTID, value);
		return this;
	}

	/**
	 * Get the <I>MQTTOutputNodeUDN</I> "<I>Client ID</I>" property
	 * 
	 * @return String; the value of the property "<I>Client ID</I>"
	 */
	public String getClientId() {
		return (String)getPropertyValue(MQTTOutputNodeUDN.PROPERTY_CLIENTID);
	}

	/**
	 * Set the <I>MQTTOutputNodeUDN</I> "<I>Topic name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Topic name</I>"
	 */
	public MQTTOutputNodeUDN setTopicName(String value) {
		setProperty(MQTTOutputNodeUDN.PROPERTY_TOPICNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTOutputNodeUDN</I> "<I>Topic name</I>" property
	 * 
	 * @return String; the value of the property "<I>Topic name</I>"
	 */
	public String getTopicName() {
		return (String)getPropertyValue(MQTTOutputNodeUDN.PROPERTY_TOPICNAME);
	}

	/**
	 * Set the <I>MQTTOutputNodeUDN</I> "<I>Connection URL</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Connection URL</I>"
	 */
	public MQTTOutputNodeUDN setBrokerUrl(String value) {
		setProperty(MQTTOutputNodeUDN.PROPERTY_BROKERURL, value);
		return this;
	}

	/**
	 * Get the <I>MQTTOutputNodeUDN</I> "<I>Connection URL</I>" property
	 * 
	 * @return String; the value of the property "<I>Connection URL</I>"
	 */
	public String getBrokerUrl() {
		return (String)getPropertyValue(MQTTOutputNodeUDN.PROPERTY_BROKERURL);
	}

	/**
	 * Set the <I>MQTTOutputNodeUDN</I> "<I>Connector name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Connector name</I>"
	 */
	public MQTTOutputNodeUDN setConnectorName(String value) {
		setProperty(MQTTOutputNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTOutputNodeUDN</I> "<I>Connector name</I>" property
	 * 
	 * @return String; the value of the property "<I>Connector name</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(MQTTOutputNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>MQTTOutputNodeUDN</I> "<I>Validate</I>" property
	 * 
	 * @param value ENUM_MQTTOUTPUT_VALIDATEMASTER ; the value to set the property "<I>Validate</I>"
	 */
	public MQTTOutputNodeUDN setValidateMaster(ENUM_MQTTOUTPUT_VALIDATEMASTER value) {
		setProperty(MQTTOutputNodeUDN.PROPERTY_VALIDATEMASTER, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTOutputNodeUDN</I> "<I>Validate</I>" property
	 * 
	 * @return ENUM_MQTTOUTPUT_VALIDATEMASTER; the value of the property "<I>Validate</I>"
	 */
	public ENUM_MQTTOUTPUT_VALIDATEMASTER getValidateMaster() {
		ENUM_MQTTOUTPUT_VALIDATEMASTER value = ENUM_MQTTOUTPUT_VALIDATEMASTER.getEnumFromString((String)getPropertyValue(MQTTOutputNodeUDN.PROPERTY_VALIDATEMASTER));
		return value;
	}

	/**
	 * Set the <I>MQTTOutputNodeUDN</I> "<I>Failure action</I>" property
	 * 
	 * @param value ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION ; the value to set the property "<I>Failure action</I>"
	 */
	public MQTTOutputNodeUDN setValidateFailureAction(ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION value) {
		setProperty(MQTTOutputNodeUDN.PROPERTY_VALIDATEFAILUREACTION, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTOutputNodeUDN</I> "<I>Failure action</I>" property
	 * 
	 * @return ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION; the value of the property "<I>Failure action</I>"
	 */
	public ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION getValidateFailureAction() {
		ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION value = ENUM_MQTTOUTPUT_VALIDATEFAILUREACTION.getEnumFromString((String)getPropertyValue(MQTTOutputNodeUDN.PROPERTY_VALIDATEFAILUREACTION));
		return value;
	}

	/**
	 * Set the <I>MQTTOutputNodeUDN</I> "<I>validateAllValueConstraints</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>validateAllValueConstraints</I>"
	 */
	public MQTTOutputNodeUDN setValidateAllValueConstraints(boolean value) {
		setProperty(MQTTOutputNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>MQTTOutputNodeUDN</I> "<I>validateAllValueConstraints</I>" property
	 * 
	 * @return boolean; the value of the property "<I>validateAllValueConstraints</I>"
	 */
	public boolean getValidateAllValueConstraints(){
	if (getPropertyValue(MQTTOutputNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>MQTTOutputNodeUDN</I> "<I>validateFixup</I>" property
	 * 
	 * @param value ENUM_MQTTOUTPUT_VALIDATEFIXUP ; the value to set the property "<I>validateFixup</I>"
	 */
	public MQTTOutputNodeUDN setValidateFixup(ENUM_MQTTOUTPUT_VALIDATEFIXUP value) {
		setProperty(MQTTOutputNodeUDN.PROPERTY_VALIDATEFIXUP, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTOutputNodeUDN</I> "<I>validateFixup</I>" property
	 * 
	 * @return ENUM_MQTTOUTPUT_VALIDATEFIXUP; the value of the property "<I>validateFixup</I>"
	 */
	public ENUM_MQTTOUTPUT_VALIDATEFIXUP getValidateFixup() {
		ENUM_MQTTOUTPUT_VALIDATEFIXUP value = ENUM_MQTTOUTPUT_VALIDATEFIXUP.getEnumFromString((String)getPropertyValue(MQTTOutputNodeUDN.PROPERTY_VALIDATEFIXUP));
		return value;
	}

	/**
	 * Set the <I>MQTTOutputNodeUDN</I> "<I>securityProfileName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>securityProfileName</I>"
	 */
	public MQTTOutputNodeUDN setSecurityProfileName(String value) {
		setProperty(MQTTOutputNodeUDN.PROPERTY_SECURITYPROFILENAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTOutputNodeUDN</I> "<I>securityProfileName</I>" property
	 * 
	 * @return String; the value of the property "<I>securityProfileName</I>"
	 */
	public String getSecurityProfileName() {
		return (String)getPropertyValue(MQTTOutputNodeUDN.PROPERTY_SECURITYPROFILENAME);
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "MQTT Output";
		return retVal;
	};
}
