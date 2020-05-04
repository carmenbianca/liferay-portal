/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author Bruno Farache
 */
public class SerializableSessionAttributeListener
	implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(
		HttpSessionBindingEvent httpSessionBindingEvent) {

		Object value = httpSessionBindingEvent.getValue();

		if ((value instanceof Serializable) || (value == null)) {
			return;
		}

		Class<?> clazz = value.getClass();

		_log.error(
			clazz.getName() +
				" is not serializable and will prevent this session from " +
					"being replicated");

		if (_requiresSerializable == null) {
			HttpSession session = httpSessionBindingEvent.getSession();

			ServletContext servletContext = session.getServletContext();

			_requiresSerializable = Boolean.valueOf(
				GetterUtil.getBoolean(
					servletContext.getInitParameter(
						"session-attributes-requires-serializable")));
		}

		if (_requiresSerializable) {
			HttpSession session = httpSessionBindingEvent.getSession();

			session.removeAttribute(httpSessionBindingEvent.getName());
		}
	}

	@Override
	public void attributeRemoved(
		HttpSessionBindingEvent httpSessionBindingEvent) {
	}

	@Override
	public void attributeReplaced(
		HttpSessionBindingEvent httpSessionBindingEvent) {

		attributeAdded(httpSessionBindingEvent);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SerializableSessionAttributeListener.class);

	private Boolean _requiresSerializable;

}