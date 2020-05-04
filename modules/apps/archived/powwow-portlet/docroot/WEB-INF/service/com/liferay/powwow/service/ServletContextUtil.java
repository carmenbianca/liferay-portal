/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.lang.reflect.Method;

/**
 * @author Shinn Lok
 * @generated
 */
public class ServletContextUtil {

	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ServletContextUtil.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader =
					ServletContextUtil.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
					"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod(
					"get", new Class<?>[] {String.class});

				String portletPropsServletContextName =
					(String)getMethod.invoke(
						null, "powwow-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
						"powwow-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "powwow-portlet";
			}

			return _servletContextName;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ServletContextUtil.class);

	private static String _servletContextName;

}