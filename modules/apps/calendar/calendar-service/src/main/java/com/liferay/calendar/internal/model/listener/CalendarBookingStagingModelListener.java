/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.model.listener;

import com.liferay.calendar.model.CalendarBooking;
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
public class CalendarBookingStagingModelListener
	extends BaseModelListener<CalendarBooking> {

	@Override
	public void onAfterCreate(CalendarBooking calendarBooking)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(calendarBooking);
	}

	@Override
	public void onAfterRemove(CalendarBooking calendarBooking)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(calendarBooking);
	}

	@Override
	public void onAfterUpdate(CalendarBooking calendarBooking)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(calendarBooking);
	}

	@Reference
	private StagingModelListener<CalendarBooking> _stagingModelListener;

}