/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.bean;

import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.BeanLocatorException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletBeanLocatorUtil {

	public static BeanLocator getBeanLocator() {
		return _beanLocator;
	}

	public static Object locate(String name) throws BeanLocatorException {
		if (_beanLocator == null) {
			_log.error("BeanLocator is null");

			throw new BeanLocatorException("BeanLocator is not set");
		}

		return _beanLocator.locate(name);
	}

	public static void setBeanLocator(BeanLocator beanLocator) {
		if (_log.isDebugEnabled()) {
			if (beanLocator != null) {
				_log.debug("Setting BeanLocator " + beanLocator.hashCode());
			}
			else {
				_log.debug("Setting BeanLocator null");
			}
		}

		_beanLocator = beanLocator;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PortletBeanLocatorUtil.class);

	private static BeanLocator _beanLocator;

}