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

package ims.emergency.forms.areadefinition;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Emergency = new EmergencyContext(context);
	}
	public final class EmergencyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private EmergencyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTrackingAreaCollectionIsNotNull()
		{
			return !cx_EmergencyTrackingAreaCollection.getValueIsNull(context);
		}
		public ims.emergency.vo.TrackingAreaVoCollection getTrackingAreaCollection()
		{
			return (ims.emergency.vo.TrackingAreaVoCollection)cx_EmergencyTrackingAreaCollection.getValue(context);
		}
		public void setTrackingAreaCollection(ims.emergency.vo.TrackingAreaVoCollection value)
		{
			cx_EmergencyTrackingAreaCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyTrackingAreaCollection = new ims.framework.ContextVariable("Emergency.TrackingAreaCollection", "_cv_Emergency.TrackingAreaCollection");
		public boolean getEDLocationIsNotNull()
		{
			return !cx_EmergencyEDLocation.getValueIsNull(context);
		}
		public ims.core.vo.LocationLiteVo getEDLocation()
		{
			return (ims.core.vo.LocationLiteVo)cx_EmergencyEDLocation.getValue(context);
		}
		public void setEDLocation(ims.core.vo.LocationLiteVo value)
		{
			cx_EmergencyEDLocation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyEDLocation = new ims.framework.ContextVariable("Emergency.EDLocation", "_cv_Emergency.EDLocation");
		public boolean getTrackingAreaIsNotNull()
		{
			return !cx_EmergencyTrackingArea.getValueIsNull(context);
		}
		public ims.emergency.vo.TrackingAreaVo getTrackingArea()
		{
			return (ims.emergency.vo.TrackingAreaVo)cx_EmergencyTrackingArea.getValue(context);
		}
		public void setTrackingArea(ims.emergency.vo.TrackingAreaVo value)
		{
			cx_EmergencyTrackingArea.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyTrackingArea = new ims.framework.ContextVariable("Emergency.TrackingArea", "_cv_Emergency.TrackingArea");

		private ims.framework.Context context;
	}

	public EmergencyContext Emergency;
}
