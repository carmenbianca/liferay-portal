/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.context.helper.definition;

import java.util.EventListener;
import java.util.Objects;

/**
 * @author Raymond Augé
 */
public class ListenerDefinition {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ListenerDefinition)) {
			return false;
		}

		ListenerDefinition listenerDefinition = (ListenerDefinition)obj;

		if (Objects.equals(
				_eventListener.getClass(),
				listenerDefinition._eventListener.getClass())) {

			return true;
		}

		return false;
	}

	public EventListener getEventListener() {
		return _eventListener;
	}

	@Override
	public int hashCode() {
		if (_eventListener == null) {
			return super.hashCode();
		}

		Class<?> clazz = _eventListener.getClass();

		return clazz.hashCode();
	}

	public void setEventListener(EventListener eventListener) {
		_eventListener = eventListener;
	}

	private EventListener _eventListener;

}