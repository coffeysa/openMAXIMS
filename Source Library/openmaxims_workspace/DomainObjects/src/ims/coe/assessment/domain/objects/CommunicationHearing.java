//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 12/10/2015, 13:28
 *
 */
package ims.coe.assessment.domain.objects;

/**
 * 
 * @author Sinead McDermott
 * Generated.
 */


public class CommunicationHearing extends ims.domain.DomainObject implements java.io.Serializable {
	public static final int CLASSID = 1012100013;
	private static final long serialVersionUID = 1012100013L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	private ims.domain.lookups.LookupInstance hearingImpairment;
	private ims.domain.lookups.LookupInstance effectedEars;
	private ims.domain.lookups.LookupInstance hearingAid;
	private ims.domain.lookups.LookupInstance hearingAidWithPatientOnAdmission;
	private ims.domain.lookups.LookupInstance batteriesInOrder;
	private Integer yearLastHearingTest;
    public CommunicationHearing (Integer id, int ver)
    {
    	super(id, ver);
    }
    public CommunicationHearing ()
    {
    	super();
    }
    public CommunicationHearing (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.coe.assessment.domain.objects.CommunicationHearing.class;
	}


	public ims.domain.lookups.LookupInstance getHearingImpairment() {
		return hearingImpairment;
	}
	public void setHearingImpairment(ims.domain.lookups.LookupInstance hearingImpairment) {
		this.hearingImpairment = hearingImpairment;
	}

	public ims.domain.lookups.LookupInstance getEffectedEars() {
		return effectedEars;
	}
	public void setEffectedEars(ims.domain.lookups.LookupInstance effectedEars) {
		this.effectedEars = effectedEars;
	}

	public ims.domain.lookups.LookupInstance getHearingAid() {
		return hearingAid;
	}
	public void setHearingAid(ims.domain.lookups.LookupInstance hearingAid) {
		this.hearingAid = hearingAid;
	}

	public ims.domain.lookups.LookupInstance getHearingAidWithPatientOnAdmission() {
		return hearingAidWithPatientOnAdmission;
	}
	public void setHearingAidWithPatientOnAdmission(ims.domain.lookups.LookupInstance hearingAidWithPatientOnAdmission) {
		this.hearingAidWithPatientOnAdmission = hearingAidWithPatientOnAdmission;
	}

	public ims.domain.lookups.LookupInstance getBatteriesInOrder() {
		return batteriesInOrder;
	}
	public void setBatteriesInOrder(ims.domain.lookups.LookupInstance batteriesInOrder) {
		this.batteriesInOrder = batteriesInOrder;
	}

	public Integer getYearLastHearingTest() {
		return yearLastHearingTest;
	}
	public void setYearLastHearingTest(Integer yearLastHearingTest) {
		this.yearLastHearingTest = yearLastHearingTest;
	}

	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Instantiation".equals("Configuration") )
			return true;
		else
			return false;
	}





	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*hearingImpairment* :");
		if (hearingImpairment != null)
			auditStr.append(hearingImpairment.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*effectedEars* :");
		if (effectedEars != null)
			auditStr.append(effectedEars.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*hearingAid* :");
		if (hearingAid != null)
			auditStr.append(hearingAid.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*hearingAidWithPatientOnAdmission* :");
		if (hearingAidWithPatientOnAdmission != null)
			auditStr.append(hearingAidWithPatientOnAdmission.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*batteriesInOrder* :");
		if (batteriesInOrder != null)
			auditStr.append(batteriesInOrder.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*yearLastHearingTest* :");
		auditStr.append(yearLastHearingTest);
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "CommunicationHearing";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getHearingImpairment() != null)
		{
			sb.append("<hearingImpairment>");
			sb.append(this.getHearingImpairment().toXMLString()); 
			sb.append("</hearingImpairment>");		
		}
		if (this.getEffectedEars() != null)
		{
			sb.append("<effectedEars>");
			sb.append(this.getEffectedEars().toXMLString()); 
			sb.append("</effectedEars>");		
		}
		if (this.getHearingAid() != null)
		{
			sb.append("<hearingAid>");
			sb.append(this.getHearingAid().toXMLString()); 
			sb.append("</hearingAid>");		
		}
		if (this.getHearingAidWithPatientOnAdmission() != null)
		{
			sb.append("<hearingAidWithPatientOnAdmission>");
			sb.append(this.getHearingAidWithPatientOnAdmission().toXMLString()); 
			sb.append("</hearingAidWithPatientOnAdmission>");		
		}
		if (this.getBatteriesInOrder() != null)
		{
			sb.append("<batteriesInOrder>");
			sb.append(this.getBatteriesInOrder().toXMLString()); 
			sb.append("</batteriesInOrder>");		
		}
		if (this.getYearLastHearingTest() != null)
		{
			sb.append("<yearLastHearingTest>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getYearLastHearingTest().toString()));
			sb.append("</yearLastHearingTest>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			CommunicationHearing domainObject = getCommunicationHearingfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			CommunicationHearing domainObject = getCommunicationHearingfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static CommunicationHearing getCommunicationHearingfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getCommunicationHearingfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static CommunicationHearing getCommunicationHearingfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!CommunicationHearing.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!CommunicationHearing.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the CommunicationHearing class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (CommunicationHearing)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(CommunicationHearing.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		CommunicationHearing ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (CommunicationHearing)factory.getImportedDomainObject(CommunicationHearing.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new CommunicationHearing();
		}
		String keyClassName = "CommunicationHearing";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (CommunicationHearing)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, CommunicationHearing obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("hearingImpairment");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setHearingImpairment(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("effectedEars");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setEffectedEars(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("hearingAid");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setHearingAid(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("hearingAidWithPatientOnAdmission");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setHearingAidWithPatientOnAdmission(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("batteriesInOrder");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setBatteriesInOrder(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("yearLastHearingTest");
		if(fldEl != null)
		{	
    		obj.setYearLastHearingTest(new Integer(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String HearingImpairment = "hearingImpairment";
		public static final String EffectedEars = "effectedEars";
		public static final String HearingAid = "hearingAid";
		public static final String HearingAidWithPatientOnAdmission = "hearingAidWithPatientOnAdmission";
		public static final String BatteriesInOrder = "batteriesInOrder";
		public static final String YearLastHearingTest = "yearLastHearingTest";
	}
}

