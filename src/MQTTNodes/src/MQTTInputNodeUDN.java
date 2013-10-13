package ComIbm;

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import java.util.Vector;
import com.ibm.broker.config.appdev.NodePropertyRow;
import com.ibm.broker.config.appdev.NodePropertyTable;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>MQTTInputNodeUDN</I> instance</p>
 * <p></p>
 */
public class MQTTInputNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "ComIbm/EventInputNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/MQTTNodes/icons/full/obj16/ComIbmEventInput.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/MQTTNodes/icons/full/obj30/ComIbmEventInput.gif";

	protected final static String PROPERTY_CLIENTID = "clientId";
	protected final static String PROPERTY_TOPICNAME = "topicName";
	protected final static String PROPERTY_BROKERURL = "brokerUrl";
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
	 * <I>ENUM_MQTTINPUT_VALIDATEFAILUREACTION</I>
	 * <pre>
	 * ENUM_MQTTINPUT_VALIDATEFAILUREACTION.userTrace = User Trace
	 * ENUM_MQTTINPUT_VALIDATEFAILUREACTION.localError = Local Error Log
	 * ENUM_MQTTINPUT_VALIDATEFAILUREACTION.exception = Exception
	 * ENUM_MQTTINPUT_VALIDATEFAILUREACTION.exceptionList = Exception List
	 * </pre>
	 */
	public static class ENUM_MQTTINPUT_VALIDATEFAILUREACTION {
		private String value;

		public static final ENUM_MQTTINPUT_VALIDATEFAILUREACTION userTrace = new ENUM_MQTTINPUT_VALIDATEFAILUREACTION("userTrace");
		public static final ENUM_MQTTINPUT_VALIDATEFAILUREACTION localError = new ENUM_MQTTINPUT_VALIDATEFAILUREACTION("localError");
		public static final ENUM_MQTTINPUT_VALIDATEFAILUREACTION exception = new ENUM_MQTTINPUT_VALIDATEFAILUREACTION("exception");
		public static final ENUM_MQTTINPUT_VALIDATEFAILUREACTION exceptionList = new ENUM_MQTTINPUT_VALIDATEFAILUREACTION("exceptionList");

		protected ENUM_MQTTINPUT_VALIDATEFAILUREACTION(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTINPUT_VALIDATEFAILUREACTION getEnumFromString(String enumValue) {
			ENUM_MQTTINPUT_VALIDATEFAILUREACTION enumConst = ENUM_MQTTINPUT_VALIDATEFAILUREACTION.userTrace;
			if (ENUM_MQTTINPUT_VALIDATEFAILUREACTION.localError.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_VALIDATEFAILUREACTION.localError;
			if (ENUM_MQTTINPUT_VALIDATEFAILUREACTION.exception.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_VALIDATEFAILUREACTION.exception;
			if (ENUM_MQTTINPUT_VALIDATEFAILUREACTION.exceptionList.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_VALIDATEFAILUREACTION.exceptionList;
			return enumConst;
		}

		public static String[] values = new String[]{ "userTrace", "localError", "exception", "exceptionList" };

	}

	/**
	 * <I>ENUM_MQTTINPUT_VALIDATEFIXUP</I>
	 * <pre>
	 * ENUM_MQTTINPUT_VALIDATEFIXUP.none = None
	 * ENUM_MQTTINPUT_VALIDATEFIXUP.full = Full
	 * </pre>
	 */
	public static class ENUM_MQTTINPUT_VALIDATEFIXUP {
		private String value;

		public static final ENUM_MQTTINPUT_VALIDATEFIXUP none = new ENUM_MQTTINPUT_VALIDATEFIXUP("none");
		public static final ENUM_MQTTINPUT_VALIDATEFIXUP full = new ENUM_MQTTINPUT_VALIDATEFIXUP("full");

		protected ENUM_MQTTINPUT_VALIDATEFIXUP(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTINPUT_VALIDATEFIXUP getEnumFromString(String enumValue) {
			ENUM_MQTTINPUT_VALIDATEFIXUP enumConst = ENUM_MQTTINPUT_VALIDATEFIXUP.none;
			if (ENUM_MQTTINPUT_VALIDATEFIXUP.full.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_VALIDATEFIXUP.full;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "full" };

	}

	/**
	 * <I>ENUM_MQTTINPUT_VALIDATETIMING</I>
	 * <pre>
	 * ENUM_MQTTINPUT_VALIDATETIMING.deferred = On Demand
	 * ENUM_MQTTINPUT_VALIDATETIMING.immediate = Immediate
	 * ENUM_MQTTINPUT_VALIDATETIMING.complete = Complete
	 * </pre>
	 */
	public static class ENUM_MQTTINPUT_VALIDATETIMING {
		private String value;

		public static final ENUM_MQTTINPUT_VALIDATETIMING deferred = new ENUM_MQTTINPUT_VALIDATETIMING("deferred");
		public static final ENUM_MQTTINPUT_VALIDATETIMING immediate = new ENUM_MQTTINPUT_VALIDATETIMING("immediate");
		public static final ENUM_MQTTINPUT_VALIDATETIMING complete = new ENUM_MQTTINPUT_VALIDATETIMING("complete");

		protected ENUM_MQTTINPUT_VALIDATETIMING(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTINPUT_VALIDATETIMING getEnumFromString(String enumValue) {
			ENUM_MQTTINPUT_VALIDATETIMING enumConst = ENUM_MQTTINPUT_VALIDATETIMING.deferred;
			if (ENUM_MQTTINPUT_VALIDATETIMING.immediate.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_VALIDATETIMING.immediate;
			if (ENUM_MQTTINPUT_VALIDATETIMING.complete.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_VALIDATETIMING.complete;
			return enumConst;
		}

		public static String[] values = new String[]{ "deferred", "immediate", "complete" };

	}

	/**
	 * <I>ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE</I>
	 * <pre>
	 * ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE.none = None
	 * ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE.all = all
	 * </pre>
	 */
	public static class ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE {
		private String value;

		public static final ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE none = new ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE("none");
		public static final ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE all = new ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE("all");

		protected ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE getEnumFromString(String enumValue) {
			ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE enumConst = ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE.none;
			if (ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE.all.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE.all;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "all" };

	}

	/**
	 * <I>ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE</I>
	 * <pre>
	 * ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE.none = None
	 * ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE.all = all
	 * </pre>
	 */
	public static class ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE {
		private String value;

		public static final ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE none = new ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE("none");
		public static final ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE all = new ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE("all");

		protected ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE getEnumFromString(String enumValue) {
			ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE enumConst = ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE.none;
			if (ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE.all.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE.all;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "all" };

	}

	/**
	 * <I>ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE</I>
	 * <pre>
	 * ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.none = None
	 * ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.all = All
	 * </pre>
	 */
	public static class ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE {
		private String value;

		public static final ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE none = new ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE("none");
		public static final ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE all = new ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE("all");

		protected ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE getEnumFromString(String enumValue) {
			ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE enumConst = ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.none;
			if (ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.all.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.all;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "all" };

	}

	/**
	 * <I>ENUM_MQTTINPUT_VALIDATEMASTER</I>
	 * <pre>
	 * ENUM_MQTTINPUT_VALIDATEMASTER.none = None
	 * ENUM_MQTTINPUT_VALIDATEMASTER.contentAndValue = Content and Value
	 * ENUM_MQTTINPUT_VALIDATEMASTER.content = Content
	 * </pre>
	 */
	public static class ENUM_MQTTINPUT_VALIDATEMASTER {
		private String value;

		public static final ENUM_MQTTINPUT_VALIDATEMASTER none = new ENUM_MQTTINPUT_VALIDATEMASTER("none");
		public static final ENUM_MQTTINPUT_VALIDATEMASTER contentAndValue = new ENUM_MQTTINPUT_VALIDATEMASTER("contentAndValue");
		public static final ENUM_MQTTINPUT_VALIDATEMASTER content = new ENUM_MQTTINPUT_VALIDATEMASTER("content");

		protected ENUM_MQTTINPUT_VALIDATEMASTER(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_MQTTINPUT_VALIDATEMASTER getEnumFromString(String enumValue) {
			ENUM_MQTTINPUT_VALIDATEMASTER enumConst = ENUM_MQTTINPUT_VALIDATEMASTER.none;
			if (ENUM_MQTTINPUT_VALIDATEMASTER.contentAndValue.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_VALIDATEMASTER.contentAndValue;
			if (ENUM_MQTTINPUT_VALIDATEMASTER.content.value.equals(enumValue)) enumConst = ENUM_MQTTINPUT_VALIDATEMASTER.content;
			return enumConst;
		}

		public static String[] values = new String[]{ "none", "contentAndValue", "content" };

	}
	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_CLIENTID,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_TOPICNAME,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_BROKERURL,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "MQTT","","",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageDomainPropertyEditor",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_MESSAGESETPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageSetNamePropertyEditorV8",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_MESSAGETYPEPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageTypePropertyEditorV8",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_MESSAGEFORMATPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageFormatPropertyEditor",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_VALIDATETIMING,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "deferred", ENUM_MQTTINPUT_VALIDATETIMING.class,"","",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCBUILDTREEUSINGXMLSCHEMA,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.BOOLEAN, "false",	"com.ibm.etools.mft.ibmnodes.compilers.BooleanPropertyCompiler",	"com.ibm.etools.mft.ibmnodes.editors.BuildTreePropertyEditor",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCUSEFORXMLNSDOMAIN,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.BOOLEAN, "false",	"com.ibm.etools.mft.ibmnodes.compilers.BooleanPropertyCompiler",	"com.ibm.etools.mft.ibmnodes.editors.XmlnsMessageDomainPropertyEditor",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCMIXEDCONTENTRETAINMODE,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE.class,"",	"com.ibm.etools.mft.ibmnodes.editors.XmlnscPropertyEditor",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCCOMMENTSRETAINMODE,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE.class,"",	"com.ibm.etools.mft.ibmnodes.editors.XmlnscPropertyEditor",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.class,"",	"com.ibm.etools.mft.ibmnodes.editors.XmlnscPropertyEditor",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_VALIDATEMASTER,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTINPUT_VALIDATEMASTER.class,"",	"com.ibm.etools.mft.ibmnodes.editors.ValidateMasterForOpaqueParsingAndBuildTreePropertyEditor",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_VALIDATEFAILUREACTION,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "exception", ENUM_MQTTINPUT_VALIDATEFAILUREACTION.class,"",	"com.ibm.etools.mft.ibmnodes.editors.ValidateMasterListenerPropertyEditor",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.BOOLEAN, "true",	"com.ibm.etools.mft.ibmnodes.compilers.BooleanPropertyCompiler","",	"ComIbmEventInput",	"MQTTNodes"),
			new NodeProperty(MQTTInputNodeUDN.PROPERTY_VALIDATEFIXUP,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.ENUMERATION, "none", ENUM_MQTTINPUT_VALIDATEFIXUP.class,"","",	"ComIbmEventInput",	"MQTTNodes")
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
			new NodeProperty(PROPERTY_ELEMENTS,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.xpath.XPathOpaqueParsingCellPropertyEditor",	"ComIbmEventInput",	"MQTTNodes")
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
	 * Retrieve the Opaque elements table for the node <I>MQTTInputNodeUDN</I
	 * @return ParserXmlnscOpaqueElementsTable instance which contains parserXmlnscOpaqueElementsRow rows

	 */
	public ParserXmlnscOpaqueElementsTable getParserXmlnscOpaqueElementsTable() {
		for (int i = 0; i < nodePropertyTables.size(); i++) {
			if (nodePropertyTables.get(i) instanceof ParserXmlnscOpaqueElementsTable)
				return (ParserXmlnscOpaqueElementsTable)nodePropertyTables.get(i);
			}
		return null;
	}

	public MQTTInputNodeUDN() {
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
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Client ID</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Client ID</I>"
	 */
	public MQTTInputNodeUDN setClientId(String value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_CLIENTID, value);
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Client ID</I>" property
	 * 
	 * @return String; the value of the property "<I>Client ID</I>"
	 */
	public String getClientId() {
		return (String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_CLIENTID);
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Topic name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Topic name</I>"
	 */
	public MQTTInputNodeUDN setTopicName(String value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_TOPICNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Topic name</I>" property
	 * 
	 * @return String; the value of the property "<I>Topic name</I>"
	 */
	public String getTopicName() {
		return (String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_TOPICNAME);
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Connection URL</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Connection URL</I>"
	 */
	public MQTTInputNodeUDN setBrokerUrl(String value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_BROKERURL, value);
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Connection URL</I>" property
	 * 
	 * @return String; the value of the property "<I>Connection URL</I>"
	 */
	public String getBrokerUrl() {
		return (String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_BROKERURL);
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Connector name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Connector name</I>"
	 */
	public MQTTInputNodeUDN setConnectorName(String value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Connector name</I>" property
	 * 
	 * @return String; the value of the property "<I>Connector name</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Message domain</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Message domain</I>"
	 */
	public MQTTInputNodeUDN setMessageDomainProperty(String value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Message domain</I>" property
	 * 
	 * @return String; the value of the property "<I>Message domain</I>"
	 */
	public String getMessageDomainProperty() {
		return (String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY);
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Message model</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Message model</I>"
	 */
	public MQTTInputNodeUDN setMessageSetProperty(String value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_MESSAGESETPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Message model</I>" property
	 * 
	 * @return String; the value of the property "<I>Message model</I>"
	 */
	public String getMessageSetProperty() {
		return (String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_MESSAGESETPROPERTY);
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Message</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Message</I>"
	 */
	public MQTTInputNodeUDN setMessageTypeProperty(String value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_MESSAGETYPEPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Message</I>" property
	 * 
	 * @return String; the value of the property "<I>Message</I>"
	 */
	public String getMessageTypeProperty() {
		return (String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_MESSAGETYPEPROPERTY);
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Physical format</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Physical format</I>"
	 */
	public MQTTInputNodeUDN setMessageFormatProperty(String value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_MESSAGEFORMATPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Physical format</I>" property
	 * 
	 * @return String; the value of the property "<I>Physical format</I>"
	 */
	public String getMessageFormatProperty() {
		return (String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_MESSAGEFORMATPROPERTY);
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Parse timing</I>" property
	 * 
	 * @param value ENUM_MQTTINPUT_VALIDATETIMING ; the value to set the property "<I>Parse timing</I>"
	 */
	public MQTTInputNodeUDN setValidateTiming(ENUM_MQTTINPUT_VALIDATETIMING value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_VALIDATETIMING, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Parse timing</I>" property
	 * 
	 * @return ENUM_MQTTINPUT_VALIDATETIMING; the value of the property "<I>Parse timing</I>"
	 */
	public ENUM_MQTTINPUT_VALIDATETIMING getValidateTiming() {
		ENUM_MQTTINPUT_VALIDATETIMING value = ENUM_MQTTINPUT_VALIDATETIMING.getEnumFromString((String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_VALIDATETIMING));
		return value;
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Build tree using XML schema data types</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>Build tree using XML schema data types</I>"
	 */
	public MQTTInputNodeUDN setParserXmlnscBuildTreeUsingXMLSchema(boolean value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCBUILDTREEUSINGXMLSCHEMA, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Build tree using XML schema data types</I>" property
	 * 
	 * @return boolean; the value of the property "<I>Build tree using XML schema data types</I>"
	 */
	public boolean getParserXmlnscBuildTreeUsingXMLSchema(){
	if (getPropertyValue(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCBUILDTREEUSINGXMLSCHEMA).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Use XMLNSC compact parser for XMLNS domain</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>Use XMLNSC compact parser for XMLNS domain</I>"
	 */
	public MQTTInputNodeUDN setParserXmlnscUseForXmlnsDomain(boolean value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCUSEFORXMLNSDOMAIN, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Use XMLNSC compact parser for XMLNS domain</I>" property
	 * 
	 * @return boolean; the value of the property "<I>Use XMLNSC compact parser for XMLNS domain</I>"
	 */
	public boolean getParserXmlnscUseForXmlnsDomain(){
	if (getPropertyValue(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCUSEFORXMLNSDOMAIN).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Retain mixed content</I>" property
	 * 
	 * @param value ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE ; the value to set the property "<I>Retain mixed content</I>"
	 */
	public MQTTInputNodeUDN setParserXmlnscMixedContentRetainMode(ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCMIXEDCONTENTRETAINMODE, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Retain mixed content</I>" property
	 * 
	 * @return ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE; the value of the property "<I>Retain mixed content</I>"
	 */
	public ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE getParserXmlnscMixedContentRetainMode() {
		ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE value = ENUM_MQTTINPUT_PARSERXMLNSCMIXEDCONTENTRETAINMODE.getEnumFromString((String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCMIXEDCONTENTRETAINMODE));
		return value;
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Retain comments</I>" property
	 * 
	 * @param value ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE ; the value to set the property "<I>Retain comments</I>"
	 */
	public MQTTInputNodeUDN setParserXmlnscCommentsRetainMode(ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCCOMMENTSRETAINMODE, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Retain comments</I>" property
	 * 
	 * @return ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE; the value of the property "<I>Retain comments</I>"
	 */
	public ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE getParserXmlnscCommentsRetainMode() {
		ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE value = ENUM_MQTTINPUT_PARSERXMLNSCCOMMENTSRETAINMODE.getEnumFromString((String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCCOMMENTSRETAINMODE));
		return value;
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Retain processing instructions</I>" property
	 * 
	 * @param value ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE ; the value to set the property "<I>Retain processing instructions</I>"
	 */
	public MQTTInputNodeUDN setParserXmlnscProcessingInstructionsRetainMode(ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Retain processing instructions</I>" property
	 * 
	 * @return ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE; the value of the property "<I>Retain processing instructions</I>"
	 */
	public ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE getParserXmlnscProcessingInstructionsRetainMode() {
		ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE value = ENUM_MQTTINPUT_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE.getEnumFromString((String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_PARSERXMLNSCPROCESSINGINSTRUCTIONSRETAINMODE));
		return value;
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Validate</I>" property
	 * 
	 * @param value ENUM_MQTTINPUT_VALIDATEMASTER ; the value to set the property "<I>Validate</I>"
	 */
	public MQTTInputNodeUDN setValidateMaster(ENUM_MQTTINPUT_VALIDATEMASTER value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_VALIDATEMASTER, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Validate</I>" property
	 * 
	 * @return ENUM_MQTTINPUT_VALIDATEMASTER; the value of the property "<I>Validate</I>"
	 */
	public ENUM_MQTTINPUT_VALIDATEMASTER getValidateMaster() {
		ENUM_MQTTINPUT_VALIDATEMASTER value = ENUM_MQTTINPUT_VALIDATEMASTER.getEnumFromString((String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_VALIDATEMASTER));
		return value;
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Failure action</I>" property
	 * 
	 * @param value ENUM_MQTTINPUT_VALIDATEFAILUREACTION ; the value to set the property "<I>Failure action</I>"
	 */
	public MQTTInputNodeUDN setValidateFailureAction(ENUM_MQTTINPUT_VALIDATEFAILUREACTION value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_VALIDATEFAILUREACTION, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Failure action</I>" property
	 * 
	 * @return ENUM_MQTTINPUT_VALIDATEFAILUREACTION; the value of the property "<I>Failure action</I>"
	 */
	public ENUM_MQTTINPUT_VALIDATEFAILUREACTION getValidateFailureAction() {
		ENUM_MQTTINPUT_VALIDATEFAILUREACTION value = ENUM_MQTTINPUT_VALIDATEFAILUREACTION.getEnumFromString((String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_VALIDATEFAILUREACTION));
		return value;
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Include all value constraints</I>" property
	 * 
	 * @param value boolean ; the value to set the property "<I>Include all value constraints</I>"
	 */
	public MQTTInputNodeUDN setValidateAllValueConstraints(boolean value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS, String.valueOf(value));
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Include all value constraints</I>" property
	 * 
	 * @return boolean; the value of the property "<I>Include all value constraints</I>"
	 */
	public boolean getValidateAllValueConstraints(){
	if (getPropertyValue(MQTTInputNodeUDN.PROPERTY_VALIDATEALLVALUECONSTRAINTS).equals("true")){
		return true;
	} else {
		return false;
		}
	}

	/**
	 * Set the <I>MQTTInputNodeUDN</I> "<I>Fix</I>" property
	 * 
	 * @param value ENUM_MQTTINPUT_VALIDATEFIXUP ; the value to set the property "<I>Fix</I>"
	 */
	public MQTTInputNodeUDN setValidateFixup(ENUM_MQTTINPUT_VALIDATEFIXUP value) {
		setProperty(MQTTInputNodeUDN.PROPERTY_VALIDATEFIXUP, value.toString());
		return this;
	}

	/**
	 * Get the <I>MQTTInputNodeUDN</I> "<I>Fix</I>" property
	 * 
	 * @return ENUM_MQTTINPUT_VALIDATEFIXUP; the value of the property "<I>Fix</I>"
	 */
	public ENUM_MQTTINPUT_VALIDATEFIXUP getValidateFixup() {
		ENUM_MQTTINPUT_VALIDATEFIXUP value = ENUM_MQTTINPUT_VALIDATEFIXUP.getEnumFromString((String)getPropertyValue(MQTTInputNodeUDN.PROPERTY_VALIDATEFIXUP));
		return value;
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "MQTT Input";
		return retVal;
	};
}
