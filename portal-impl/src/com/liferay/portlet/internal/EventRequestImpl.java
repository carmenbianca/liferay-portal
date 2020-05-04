/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import com.liferay.portal.kernel.portlet.LiferayEventRequest;

import javax.portlet.Event;
import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Neil Griffin
 */
public class EventRequestImpl
	extends PortletRequestImpl implements LiferayEventRequest {

	@Override
	public Event getEvent() {
		return _event;
	}

	@Override
	public String getLifecycle() {
		return PortletRequest.EVENT_PHASE;
	}

	@Override
	public void setEvent(Event event) {
		_event = event;
	}

	private Event _event;

}