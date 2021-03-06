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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.pathways.vo;

/**
 * Linked to Pathways.PatientJourneyComment business object (ID: 1088100012).
 */
public class PatientJourneyCommentLiteVo extends ims.pathways.vo.PatientJourneyCommentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientJourneyCommentLiteVo()
	{
	}
	public PatientJourneyCommentLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientJourneyCommentLiteVo(ims.pathways.vo.beans.PatientJourneyCommentLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.recordinginfo = bean.getRecordingInfo() == null ? null : bean.getRecordingInfo().buildVo();
		this.comment = bean.getComment();
		this.commentlevel = bean.getCommentLevel() == null ? null : ims.pathways.vo.lookups.CommentLevel.buildLookup(bean.getCommentLevel());
		this.corrected = bean.getCorrected();
		this.correctioncomments = bean.getCorrectionComments();
		this.correctedauthoringinformation = bean.getCorrectedAuthoringInformation() == null ? null : bean.getCorrectedAuthoringInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PatientJourneyCommentLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.recordinginfo = bean.getRecordingInfo() == null ? null : bean.getRecordingInfo().buildVo(map);
		this.comment = bean.getComment();
		this.commentlevel = bean.getCommentLevel() == null ? null : ims.pathways.vo.lookups.CommentLevel.buildLookup(bean.getCommentLevel());
		this.corrected = bean.getCorrected();
		this.correctioncomments = bean.getCorrectionComments();
		this.correctedauthoringinformation = bean.getCorrectedAuthoringInformation() == null ? null : bean.getCorrectedAuthoringInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PatientJourneyCommentLiteVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PatientJourneyCommentLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PatientJourneyCommentLiteVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("RECORDINGINFO"))
			return getRecordingInfo();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("COMMENTLEVEL"))
			return getCommentLevel();
		if(fieldName.equals("CORRECTED"))
			return getCorrected();
		if(fieldName.equals("CORRECTIONCOMMENTS"))
			return getCorrectionComments();
		if(fieldName.equals("CORRECTEDAUTHORINGINFORMATION"))
			return getCorrectedAuthoringInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRecordingInfoIsNotNull()
	{
		return this.recordinginfo != null;
	}
	public ims.core.vo.RecordingUserInformationVo getRecordingInfo()
	{
		return this.recordinginfo;
	}
	public void setRecordingInfo(ims.core.vo.RecordingUserInformationVo value)
	{
		this.isValidated = false;
		this.recordinginfo = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 3000;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getCommentLevelIsNotNull()
	{
		return this.commentlevel != null;
	}
	public ims.pathways.vo.lookups.CommentLevel getCommentLevel()
	{
		return this.commentlevel;
	}
	public void setCommentLevel(ims.pathways.vo.lookups.CommentLevel value)
	{
		this.isValidated = false;
		this.commentlevel = value;
	}
	public boolean getCorrectedIsNotNull()
	{
		return this.corrected != null;
	}
	public Boolean getCorrected()
	{
		return this.corrected;
	}
	public void setCorrected(Boolean value)
	{
		this.isValidated = false;
		this.corrected = value;
	}
	public boolean getCorrectionCommentsIsNotNull()
	{
		return this.correctioncomments != null;
	}
	public String getCorrectionComments()
	{
		return this.correctioncomments;
	}
	public static int getCorrectionCommentsMaxLength()
	{
		return 250;
	}
	public void setCorrectionComments(String value)
	{
		this.isValidated = false;
		this.correctioncomments = value;
	}
	public boolean getCorrectedAuthoringInformationIsNotNull()
	{
		return this.correctedauthoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getCorrectedAuthoringInformation()
	{
		return this.correctedauthoringinformation;
	}
	public void setCorrectedAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.correctedauthoringinformation = value;
	}
	/**
	* PatientJourneyCommentLiteVoRecordingDateTimeComparator (class definition)
	*/
	public static class PatientJourneyCommentLiteVoRecordingDateTimeComparator implements java.util.Comparator
		{
			private int direction = 1;
			public PatientJourneyCommentLiteVoRecordingDateTimeComparator()
			{
				this(ims.framework.enumerations.SortOrder.ASCENDING);
			}
			public PatientJourneyCommentLiteVoRecordingDateTimeComparator (ims.framework.enumerations.SortOrder order)
			{
				if (order == ims.framework.enumerations.SortOrder.DESCENDING)
				{
					direction = -1;
				}
			}
			public int compare(Object obj1, Object obj2)
			{
				PatientJourneyCommentLiteVo voObj1 = (PatientJourneyCommentLiteVo)obj1;
				PatientJourneyCommentLiteVo voObj2 = (PatientJourneyCommentLiteVo)obj2;
				if (voObj1.getRecordingInfoIsNotNull()
					&& voObj2.getRecordingInfoIsNotNull())
				{	
					if (voObj1.getRecordingInfo().getRecordingDateTime() == null)
						return -1;
					if (voObj2.getRecordingInfo().getRecordingDateTime() == null)
						return 1;			
			
					return direction*(voObj1.getRecordingInfo().getRecordingDateTime().compareTo(voObj2.getRecordingInfo().getRecordingDateTime()));
				}
				else
					return direction;
			}
			public boolean equals(Object obj)
			{
				return false;
			}	
		}
	/**
	* getRecordingDateTimeComparator - retrieves a new instance of static class PatientJourneyCommentLiteVoRecordingDateTimeComparator
	*/
	public static PatientJourneyCommentLiteVoRecordingDateTimeComparator getRecordingDateTimeComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new PatientJourneyCommentLiteVo.PatientJourneyCommentLiteVoRecordingDateTimeComparator(sortOrder);
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.recordinginfo != null)
		{
			if(!this.recordinginfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.correctedauthoringinformation != null)
		{
			if(!this.correctedauthoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.recordinginfo == null)
			listOfErrors.add("RecordingInfo is mandatory");
		if(this.recordinginfo != null)
		{
			String[] listOfOtherErrors = this.recordinginfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comment != null)
			if(this.comment.length() > 3000)
				listOfErrors.add("The length of the field [comment] in the value object [ims.pathways.vo.PatientJourneyCommentLiteVo] is too big. It should be less or equal to 3000");
		if(this.commentlevel == null)
			listOfErrors.add("CommentLevel is mandatory");
		if(this.correctioncomments != null)
			if(this.correctioncomments.length() > 250)
				listOfErrors.add("The length of the field [correctioncomments] in the value object [ims.pathways.vo.PatientJourneyCommentLiteVo] is too big. It should be less or equal to 250");
		if(this.correctedauthoringinformation != null)
		{
			String[] listOfOtherErrors = this.correctedauthoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientJourneyCommentLiteVo clone = new PatientJourneyCommentLiteVo(this.id, this.version);
		
		if(this.recordinginfo == null)
			clone.recordinginfo = null;
		else
			clone.recordinginfo = (ims.core.vo.RecordingUserInformationVo)this.recordinginfo.clone();
		clone.comment = this.comment;
		if(this.commentlevel == null)
			clone.commentlevel = null;
		else
			clone.commentlevel = (ims.pathways.vo.lookups.CommentLevel)this.commentlevel.clone();
		clone.corrected = this.corrected;
		clone.correctioncomments = this.correctioncomments;
		if(this.correctedauthoringinformation == null)
			clone.correctedauthoringinformation = null;
		else
			clone.correctedauthoringinformation = (ims.core.vo.AuthoringInformationVo)this.correctedauthoringinformation.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.recordinginfo != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.commentlevel != null)
			count++;
		if(this.corrected != null)
			count++;
		if(this.correctioncomments != null)
			count++;
		if(this.correctedauthoringinformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.RecordingUserInformationVo recordinginfo;
	protected String comment;
	protected ims.pathways.vo.lookups.CommentLevel commentlevel;
	protected Boolean corrected;
	protected String correctioncomments;
	protected ims.core.vo.AuthoringInformationVo correctedauthoringinformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
