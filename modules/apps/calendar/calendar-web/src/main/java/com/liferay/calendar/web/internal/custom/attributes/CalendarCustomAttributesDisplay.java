/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.web.internal.custom.attributes;

import com.liferay.calendar.constants.CalendarPortletKeys;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.expando.kernel.model.BaseCustomAttributesDisplay;
import com.liferay.expando.kernel.model.CustomAttributesDisplay;

import org.osgi.service.component.annotations.Component;

/**
 * @author Fabio Pezzutto
 * @author Eduardo Lundgren
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + CalendarPortletKeys.CALENDAR,
	service = CustomAttributesDisplay.class
)
public class CalendarCustomAttributesDisplay
	extends BaseCustomAttributesDisplay {

	@Override
	public String getClassName() {
		return CalendarBooking.class.getName();
	}

}