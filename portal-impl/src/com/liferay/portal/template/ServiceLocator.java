/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template;

import com.liferay.portal.bean.BeanLocatorImpl;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

import java.util.function.Function;

/**
 * @author Brian Wing Shun Chan
 */
public class ServiceLocator {

	public static ServiceLocator getInstance() {
		return _serviceLocator;
	}

	public Object findService(String serviceName) {
		Object bean = null;

		try {
			Registry registry = RegistryUtil.getRegistry();

			bean = registry.callService(serviceName, Function.identity());

			if (bean == null) {
				bean = PortalBeanLocatorUtil.locate(
					_getServiceName(serviceName));
			}
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		return bean;
	}

	public Object findService(String servletContextName, String serviceName) {
		Object bean = null;

		try {
			bean = PortletBeanLocatorUtil.locate(
				servletContextName, _getServiceName(serviceName));
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		return bean;
	}

	private ServiceLocator() {
	}

	private String _getServiceName(String serviceName) {
		if (!serviceName.endsWith(BeanLocatorImpl.VELOCITY_SUFFIX)) {
			serviceName += BeanLocatorImpl.VELOCITY_SUFFIX;
		}

		return serviceName;
	}

	private static final Log _log = LogFactoryUtil.getLog(ServiceLocator.class);

	private static final ServiceLocator _serviceLocator = new ServiceLocator();

}