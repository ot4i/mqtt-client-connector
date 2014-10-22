package com.ibm.connector.mqtt;

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import java.util.Vector;
import com.ibm.broker.config.appdev.NodePropertyRow;
import com.ibm.broker.config.appdev.NodePropertyTable;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>MQTTSubscribeNodeUDN</I> instance</p>
 * <p></p>
 */
public class MQTTSubscribeNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/connector/mqtt/EventInputNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/MQTTNodes/icons/full/obj16/com/ibm/connector/mqtt/ComIbmEventInput.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/MQTTNodes/icons/full/obj30/com/ibm/connector/mqtt/ComIbmEventInput.gif";

	protected final static String PROPERTY_CLIENTID = "clientId";
	protected final static String PROPERTY_TOPICNAME = "topicName";
	protected final static String PROPERTY_HOSTNAME = "hostName";
	protected final static String PROPERTY_PORT = "port";
	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_MESSAGEDOMAINPROPERTY = "messageDomainProperty";
	protected final static String PROPERTY_MESSAGESETPROPERTY = "messageSetProperty";
	protected final static String PROPERTY_MESSAGETYPEPROPERTY = "messageTypeProperty";
	protected final static String PROPERTY_MESSAGEFORMATPROPERTY = "messageFormatProperty";
	protected final static String PROPERTY_VALIDATETIMING = "validateTiming";
	protected final static String PROPERTY_PARSERXMLNSCBUILDTREEUSINGXMLSCHEMA = "parserXmlnscBuildTreeUsingXMLSchema";
	protected final static String PROPERTY_PARSERXMLNSCUSEFORXMLNSDOMAIN = "parserXmlnscUseForXmlnsDomain";
	protected final static String PROPERTY_PARSERXMLNSCMIXEDCONTENTRETAINMODE = "parserXmlnscMixedContentRetainMode";
	protected final static String PROPERTY_PARSERXMLNSCCOMMENTSRETAINMODE = "parserXmlnscCommentsRetainMode";
	protected final static String PROPERTY_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE = "parserXmlnscProcessingInstructionsRetainMode";
	protected final static String PROPERTY_VALIDATEMASTER = "validateMaster";
	protected final static String PROPERTY_VALIDATEFAILUREACTION = "validateFailureAction";
	protected final static String PROPERTY_VALIDATEALLVALUECONSTRAINTS = "validateAllValueConstraints";
	protected final static String PROPERTY_VALIDATEFIXUP = "validateFixup";


	/**
	 * <I>ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION</I>
	 * <pre>
	 * ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.userTrace = User Trace
	 * ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.localError = Local Error Log
	 * ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.exception = Exception
	 * ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.exceptionList = Exception List
	 * </pre>
	 */
	public static class ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION {
		private String value;

		public static final ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION userTrace = new ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION("userTrace");
		public static final ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION localError = new ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION("localError");
		public static final ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION exception = new ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION("exception");
		public static final ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION exceptionList = new ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION("exceptionList");

		protected ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION getEnumFromString(String enumValue) {
			ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION enumConst = ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.userTrace;
			if (ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.localError.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.localError;
			if (ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.exception.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.exception;
			if (ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.exceptionList.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.exceptionList;
			return enumConst;
		}

		public static String[] values = new String[]{ "userTrace", "localError", "exception", "exceptionList" };

	}

	/**
	 * <I>ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP</I>
	 * <pre>
	 * ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP.none = None
	 * ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP.full = Full
	 * </pre>
	 */
	public static class ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP {
		private String value;

		public static final ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP none = new ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP("none");
		public static final ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP full = new ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP("full");

		protected ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP getEnumFromString(String enumValue) {
			ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP enumConst = ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP.none;
			if (ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP.full.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP.full;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "full" };

	}

	/**
	 * <I>ENUM_MQTTSUBSCRIBE_VALIDATETIMING</I>
	 * <pre>
	 * ENUM_MQTTSUBSCRIBE_VALIDATETIMING.deferred = On Demand
	 * ENUM_MQTTSUBSCRIBE_VALIDATETIMING.immediate = Immediate
	 * ENUM_MQTTSUBSCRIBE_VALIDATETIMING.complete = Complete
	 * </pre>
	 */
	public static class ENUM_MQTTSUBSCRIBE_VALIDATETIMING {
		private String value;

		public static final ENUM_MQTTSUBSCRIBE_VALIDATETIMING deferred = new ENUM_MQTTSUBSCRIBE_VALIDATETIMING("deferred");
		public static final ENUM_MQTTSUBSCRIBE_VALIDATETIMING immediate = new ENUM_MQTTSUBSCRIBE_VALIDATETIMING("immediate");
		public static final ENUM_MQTTSUBSCRIBE_VALIDATETIMING complete = new ENUM_MQTTSUBSCRIBE_VALIDATETIMING("complete");

		protected ENUM_MQTTSUBSCRIBE_VALIDATETIMING(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTSUBSCRIBE_VALIDATETIMING getEnumFromString(String enumValue) {
			ENUM_MQTTSUBSCRIBE_VALIDATETIMING enumConst = ENUM_MQTTSUBSCRIBE_VALIDATETIMING.deferred;
			if (ENUM_MQTTSUBSCRIBE_VALIDATETIMING.immediate.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_VALIDATETIMING.immediate;
			if (ENUM_MQTTSUBSCRIBE_VALIDATETIMING.complete.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_VALIDATETIMING.complete;
			return enumConst;
		}

		public static String[] values = new String[]{ "deferred", "immediate", "complete" };

	}

	/**
	 * <I>ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE</I>
	 * <pre>
	 * ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE.none = None
	 * ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE.all = all
	 * </pre>
	 */
	public static class ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE {
		private String value;

		public static final ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE none = new ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE("none");
		public static final ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE all = new ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE("all");

		protected ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE getEnumFromString(String enumValue) {
			ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE enumConst = ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE.none;
			if (ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE.all.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE.all;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "all" };

	}

	/**
	 * <I>ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE</I>
	 * <pre>
	 * ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE.none = None
	 * ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE.all = all
	 * </pre>
	 */
	public static class ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE {
		private String value;

		public static final ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE none = new ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE("none");
		public static final ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE all = new ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE("all");

		protected ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE getEnumFromString(String enumValue) {
			ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE enumConst = ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE.none;
			if (ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE.all.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE.all;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "all" };

	}

	/**
	 * <I>ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE</I>
	 * <pre>
	 * ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.none = None
	 * ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.all = All
	 * </pre>
	 */
	public static class ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE {
		private String value;

		public static final ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE none = new ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE("none");
		public static final ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE all = new ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE("all");

		protected ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE getEnumFromString(String enumValue) {
			ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE enumConst = ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.none;
			if (ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.all.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.all;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "all" };

	}

	/**
	 * <I>ENUM_MQTTSUBSCRIBE_VALIDATEMASTER</I>
	 * <pre>
	 * ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.none = None
	 * ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.contentAndValue = Content and Value
	 * ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.content = Content
	 * </pre>
	 */
	public static class ENUM_MQTTSUBSCRIBE_VALIDATEMASTER {
		private String value;

		public static final ENUM_MQTTSUBSCRIBE_VALIDATEMASTER none = new ENUM_MQTTSUBSCRIBE_VALIDATEMASTER("none");
		public static final ENUM_MQTTSUBSCRIBE_VALIDATEMASTER contentAndValue = new ENUM_MQTTSUBSCRIBE_VALIDATEMASTER("contentAndValue");
		public static final ENUM_MQTTSUBSCRIBE_VALIDATEMASTER content = new ENUM_MQTTSUBSCRIBE_VALIDATEMASTER("content");

		protected ENUM_MQTTSUBSCRIBE_VALIDATEMASTER(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTSUBSCRIBE_VALIDATEMASTER getEnumFromString(String enumValue) {
			ENUM_MQTTSUBSCRIBE_VALIDATEMASTER enumConst = ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.none;
			if (ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.contentAndValue.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.contentAndValue;
			if (ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.content.value.equals(enumValue)) enumConst = ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.content;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "contentAndValue", "content" };

	}
	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_CLIENTID,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_TOPICNAME,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_HOSTNAME,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_PORT,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.INTEGER, "1883","","",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "MQTT","","",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageDomainPropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_MESSAGESETPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageSetNamePropertyEditorV8",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_MESSAGETYPEPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageTypePropertyEditorV8",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_MESSAGEFORMATPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageFormatPropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATETIMING,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "deferred", ENUM_MQTTSUBSCRIBE_VALIDATETIMING.class,"","",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCBUILDTREEUSINGXMLSCHEMA,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.BOOLEAN, "false",	"com.ibm.etools.mft.ibmnodes.compilers.BooleanPropertyCompiler",	"com.ibm.etools.mft.ibmnodes.editors.BuildTreePropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCUSEFORXMLNSDOMAIN,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.BOOLEAN, "false",	"com.ibm.etools.mft.ibmnodes.compilers.BooleanPropertyCompiler",	"com.ibm.etools.mft.ibmnodes.editors.XmlnsMessageDomainPropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCMIXEDCONTENTRETAINMODE,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE.class,"",	"com.ibm.etools.mft.ibmnodes.editors.XmlnscPropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCCOMMENTSRETAINMODE,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE.class,"",	"com.ibm.etools.mft.ibmnodes.editors.XmlnscPropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.class,"",	"com.ibm.etools.mft.ibmnodes.editors.XmlnscPropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEMASTER,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.class,"",	"com.ibm.etools.mft.ibmnodes.editors.ValidateMasterForOpaqueParsingAndBuildTreePropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEFAILUREACTION,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "exception", ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.class,"",	"com.ibm.etools.mft.ibmnodes.editors.ValidateMasterListenerPropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.BOOLEAN, "true",	"com.ibm.etools.mft.ibmnodes.compilers.BooleanPropertyCompiler","",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEFIXUP,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP.class,"","",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes")
		};
	}

	/**
	 * <I>ParserXmlnscOpaqueElementsTable</I> instance contains <I>parserXmlnscOpaqueElementsRow</I> rows
	 * <pre>
	 * Table name = Opaque elements
	 * Row names = parserXmlnscOpaqueElementsRow
	 * </pre>
	 */
	public class ParserXmlnscOpaqueElementsTable extends NodePropertyTable {
		private static final long serialVersionUID = 1L;

		protected static final String TABLE_NAME = "parserXmlnscOpaqueElements";

		private ParserXmlnscOpaqueElementsTable() {
			this.name = TABLE_NAME;
		}
		@SuppressWarnings("unchecked")
		@Override
		public Vector<parserXmlnscOpaqueElementsRow> getRows() {
			return (Vector<parserXmlnscOpaqueElementsRow>) super.getRows();
		}

		public parserXmlnscOpaqueElementsRow createRow() {
			return new parserXmlnscOpaqueElementsRow();
		}

	/**
	 * Adds a parserXmlnscOpaqueElementsRow to the table
	 * @param row parserXmlnscOpaqueElementsRow ; the row to add to the table
	 */ 
		public void addRow(parserXmlnscOpaqueElementsRow row) {
			rows.add(row);
		}
	/**
	 * Remove a parserXmlnscOpaqueElementsRow from the table
	 * @param row parserXmlnscOpaqueElementsRow ; the row to remove from the table
	 */ 
		public void removeRow(parserXmlnscOpaqueElementsRow row) {
			rows.remove(row);
		}
	}

	/**
	 * <I>parserXmlnscOpaqueElementsRow</I> is used by <I>ParserXmlnscOpaqueElementsTable</I> instance
	 * <pre>
	 * Table name = Opaque elements
	 * Row names = parserXmlnscOpaqueElementsRow
	 * </pre>
	 */
	public class parserXmlnscOpaqueElementsRow extends NodePropertyRow {
	private static final long serialVersionUID = 1L;

	protected static final String ROW_NAME = "parserXmlnscOpaqueElementsRow";
	protected final static String PROPERTY_ELEMENTS = "elements";

		private parserXmlnscOpaqueElementsRow() {
			this.name = ROW_NAME;
			this.nodeProperties = getNodeProperties();
		}

	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(PROPERTY_ELEMENTS,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.xpath.XPathOpaqueParsingCellPropertyEditor",	"com/ibm/connector/mqtt/ComIbmEventInput",	"MQTTNodes")
		};
	}


	/**
	 * Set the <I>parserXmlnscOpaqueElementsRow</I> "<I>Elements</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Elements</I>"
	 */
	public void setElements(String value) {
		setProperty(PROPERTY_ELEMENTS, value);
	}

	/**
	 * Get the <I>parserXmlnscOpaqueElementsRow</I> "<I>Elements</I>" property
	 * 
	 * @return String; the value of the property "<I>Elements</I>"
	 */
	public String getElements() {
		return (String)getPropertyValue(PROPERTY_ELEMENTS);
	}
}
	/**
	 * Retrieve the Opaque elements table for the node <I>MQTTSubscribeNodeUDN</I
	 * @return ParserXmlnscOpaqueElementsTable instance which contains parserXmlnscOpaqueElementsRow rows

	 */
	public ParserXmlnscOpaqueElementsTable getParserXmlnscOpaqueElementsTable() {
		for (int i = 0; i < nodePropertyTables.size(); i++) {
			if (nodePropertyTables.get(i) instanceof ParserXmlnscOpaqueElementsTable)
				return (ParserXmlnscOpaqueElementsTable)nodePropertyTables.get(i);
			}
		return null;
	}

	public MQTTSubscribeNodeUDN() {
		nodePropertyTables.add(new ParserXmlnscOpaqueElementsTable());
	}

	@Override
	public InputTerminal[] getInputTerminals() {
		return null;
	}

	public final OutputTerminal OUTPUT_TERMINAL_FAILURE = new OutputTerminal(this,"OutTerminal.failure");
	public final OutputTerminal OUTPUT_TERMINAL_CATCH = new OutputTerminal(this,"OutTerminal.catch");
	public final OutputTerminal OUTPUT_TERMINAL_OUT = new OutputTerminal(this,"OutTerminal.out");
	@Override
	public OutputTerminal[] getOutputTerminals() {
		return new OutputTerminal[] {
			OUTPUT_TERMINAL_FAILURE,
			OUTPUT_TERMINAL_CATCH,
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
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Client ID</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Client ID</I>"
	 */
	public MQTTSubscribeNodeUDN setClientId(String value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_CLIENTID, value);
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Client ID</I>" property
	 * 
	 * @return String; the value of the property "<I>Client ID</I>"
	 */
	public String getClientId() {
		return (String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_CLIENTID);
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Topic name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Topic name</I>"
	 */
	public MQTTSubscribeNodeUDN setTopicName(String value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_TOPICNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Topic name</I>" property
	 * 
	 * @return String; the value of the property "<I>Topic name</I>"
	 */
	public String getTopicName() {
		return (String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_TOPICNAME);
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Host name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Host name</I>"
	 */
	public MQTTSubscribeNodeUDN setHostName(String value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_HOSTNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Host name</I>" property
	 * 
	 * @return String; the value of the property "<I>Host name</I>"
	 */
	public String getHostName() {
		return (String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_HOSTNAME);
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Port</I>" property
	 * 
	 * @param value int ; the value to set the property "<I>Port</I>"
	 */
	public MQTTSubscribeNodeUDN setPort(int value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_PORT, Integer.toString(value));
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> <I>Port</I> property
	 * 
	 * @return int; the value of the property "<I>Port</I>"
	 */
	public int getPort() {
		String value = (String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_PORT);
		return Integer.valueOf(value).intValue();
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Connector name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Connector name</I>"
	 */
	public MQTTSubscribeNodeUDN setConnectorName(String value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Connector name</I>" property
	 * 
	 * @return String; the value of the property "<I>Connector name</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Message domain</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Message domain</I>"
	 */
	public MQTTSubscribeNodeUDN setMessageDomainProperty(String value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Message domain</I>" property
	 * 
	 * @return String; the value of the property "<I>Message domain</I>"
	 */
	public String getMessageDomainProperty() {
		return (String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY);
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Message model</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Message model</I>"
	 */
	public MQTTSubscribeNodeUDN setMessageSetProperty(String value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_MESSAGESETPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Message model</I>" property
	 * 
	 * @return String; the value of the property "<I>Message model</I>"
	 */
	public String getMessageSetProperty() {
		return (String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_MESSAGESETPROPERTY);
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Message</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Message</I>"
	 */
	public MQTTSubscribeNodeUDN setMessageTypeProperty(String value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_MESSAGETYPEPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Message</I>" property
	 * 
	 * @return String; the value of the property "<I>Message</I>"
	 */
	public String getMessageTypeProperty() {
		return (String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_MESSAGETYPEPROPERTY);
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Physical format</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Physical format</I>"
	 */
	public MQTTSubscribeNodeUDN setMessageFormatProperty(String value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_MESSAGEFORMATPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Physical format</I>" property
	 * 
	 * @return String; the value of the property "<I>Physical format</I>"
	 */
	public String getMessageFormatProperty() {
		return (String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_MESSAGEFORMATPROPERTY);
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Parse timing</I>" property
	 * 
	 * @param value ENUM_MQTTSUBSCRIBE_VALIDATETIMING ; the value to set the property "<I>Parse timing</I>"
	 */
	public MQTTSubscribeNodeUDN setValidateTiming(ENUM_MQTTSUBSCRIBE_VALIDATETIMING value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATETIMING, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Parse timing</I>" property
	 * 
	 * @return ENUM_MQTTSUBSCRIBE_VALIDATETIMING; the value of the property "<I>Parse timing</I>"
	 */
	public ENUM_MQTTSUBSCRIBE_VALIDATETIMING getValidateTiming() {
		ENUM_MQTTSUBSCRIBE_VALIDATETIMING value = ENUM_MQTTSUBSCRIBE_VALIDATETIMING.getEnumFromString((String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_VALIDATETIMING));
		return value;
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Build tree using XML schema data types</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>Build tree using XML schema data types</I>"
	 */
	public MQTTSubscribeNodeUDN setParserXmlnscBuildTreeUsingXMLSchema(boolean value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCBUILDTREEUSINGXMLSCHEMA, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Build tree using XML schema data types</I>" property
	 * 
	 * @return boolean; the value of the property "<I>Build tree using XML schema data types</I>"
	 */
	public boolean getParserXmlnscBuildTreeUsingXMLSchema(){
	if (getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCBUILDTREEUSINGXMLSCHEMA).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Use XMLNSC compact parser for XMLNS domain</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>Use XMLNSC compact parser for XMLNS domain</I>"
	 */
	public MQTTSubscribeNodeUDN setParserXmlnscUseForXmlnsDomain(boolean value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCUSEFORXMLNSDOMAIN, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Use XMLNSC compact parser for XMLNS domain</I>" property
	 * 
	 * @return boolean; the value of the property "<I>Use XMLNSC compact parser for XMLNS domain</I>"
	 */
	public boolean getParserXmlnscUseForXmlnsDomain(){
	if (getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCUSEFORXMLNSDOMAIN).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Retain mixed content</I>" property
	 * 
	 * @param value ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE ; the value to set the property "<I>Retain mixed content</I>"
	 */
	public MQTTSubscribeNodeUDN setParserXmlnscMixedContentRetainMode(ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCMIXEDCONTENTRETAINMODE, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Retain mixed content</I>" property
	 * 
	 * @return ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE; the value of the property "<I>Retain mixed content</I>"
	 */
	public ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE getParserXmlnscMixedContentRetainMode() {
		ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE value = ENUM_MQTTSUBSCRIBE_PARSERXMLNSCMIXEDCONTENTRETAINMODE.getEnumFromString((String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCMIXEDCONTENTRETAINMODE));
		return value;
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Retain comments</I>" property
	 * 
	 * @param value ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE ; the value to set the property "<I>Retain comments</I>"
	 */
	public MQTTSubscribeNodeUDN setParserXmlnscCommentsRetainMode(ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCCOMMENTSRETAINMODE, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Retain comments</I>" property
	 * 
	 * @return ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE; the value of the property "<I>Retain comments</I>"
	 */
	public ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE getParserXmlnscCommentsRetainMode() {
		ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE value = ENUM_MQTTSUBSCRIBE_PARSERXMLNSCCOMMENTSRETAINMODE.getEnumFromString((String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCCOMMENTSRETAINMODE));
		return value;
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Retain processing instructions</I>" property
	 * 
	 * @param value ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE ; the value to set the property "<I>Retain processing instructions</I>"
	 */
	public MQTTSubscribeNodeUDN setParserXmlnscProcessingInstructionsRetainMode(ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Retain processing instructions</I>" property
	 * 
	 * @return ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE; the value of the property "<I>Retain processing instructions</I>"
	 */
	public ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE getParserXmlnscProcessingInstructionsRetainMode() {
		ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE value = ENUM_MQTTSUBSCRIBE_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.getEnumFromString((String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE));
		return value;
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Validate</I>" property
	 * 
	 * @param value ENUM_MQTTSUBSCRIBE_VALIDATEMASTER ; the value to set the property "<I>Validate</I>"
	 */
	public MQTTSubscribeNodeUDN setValidateMaster(ENUM_MQTTSUBSCRIBE_VALIDATEMASTER value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEMASTER, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Validate</I>" property
	 * 
	 * @return ENUM_MQTTSUBSCRIBE_VALIDATEMASTER; the value of the property "<I>Validate</I>"
	 */
	public ENUM_MQTTSUBSCRIBE_VALIDATEMASTER getValidateMaster() {
		ENUM_MQTTSUBSCRIBE_VALIDATEMASTER value = ENUM_MQTTSUBSCRIBE_VALIDATEMASTER.getEnumFromString((String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEMASTER));
		return value;
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Failure action</I>" property
	 * 
	 * @param value ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION ; the value to set the property "<I>Failure action</I>"
	 */
	public MQTTSubscribeNodeUDN setValidateFailureAction(ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEFAILUREACTION, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Failure action</I>" property
	 * 
	 * @return ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION; the value of the property "<I>Failure action</I>"
	 */
	public ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION getValidateFailureAction() {
		ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION value = ENUM_MQTTSUBSCRIBE_VALIDATEFAILUREACTION.getEnumFromString((String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEFAILUREACTION));
		return value;
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Include all value constraints</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>Include all value constraints</I>"
	 */
	public MQTTSubscribeNodeUDN setValidateAllValueConstraints(boolean value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Include all value constraints</I>" property
	 * 
	 * @return boolean; the value of the property "<I>Include all value constraints</I>"
	 */
	public boolean getValidateAllValueConstraints(){
	if (getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>MQTTSubscribeNodeUDN</I> "<I>Fix</I>" property
	 * 
	 * @param value ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP ; the value to set the property "<I>Fix</I>"
	 */
	public MQTTSubscribeNodeUDN setValidateFixup(ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP value) {
		setProperty(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEFIXUP, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTSubscribeNodeUDN</I> "<I>Fix</I>" property
	 * 
	 * @return ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP; the value of the property "<I>Fix</I>"
	 */
	public ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP getValidateFixup() {
		ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP value = ENUM_MQTTSUBSCRIBE_VALIDATEFIXUP.getEnumFromString((String)getPropertyValue(MQTTSubscribeNodeUDN.PROPERTY_VALIDATEFIXUP));
		return value;
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "MQTT Subscribe";
		return retVal;
	};
}
