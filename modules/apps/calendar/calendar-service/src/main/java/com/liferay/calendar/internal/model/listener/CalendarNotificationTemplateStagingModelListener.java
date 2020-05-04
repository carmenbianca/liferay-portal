/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.model.listener;

import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.staging.model.listener.StagingModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true, service = ModelListener.class)
public class CalendarNotificationTemplateStagingModelListener
	extends BaseModelListener<CalendarNotificationTemplate> {

	@Override
	public void onAfterCreate(
			CalendarNotificationTemplate calendarNotificationTemplate)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(calendarNotificationTemplate);
	}

	@Override
	public void onAfterRemove(
			CalendarNotificationTemplate calendarNotificationTemplate)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(calendarNotificationTemplate);
	}

	@Override
	public void onAfterUpdate(
			CalendarNotificationTemplate calendarNotificationTemplate)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(calendarNotificationTemplate);
	}

	@Reference
	private StagingModelListener<CalendarNotificationTemplate>
		_stagingModelListener;

}