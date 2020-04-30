/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

/**
 * @author Brian Wing Shun Chan
 */
public class PropertyFactoryUtil {

	public static Property forName(String propertyName) {
		return getPropertyFactory().forName(propertyName);
	}

	public static PropertyFactory getPropertyFactory() {
		return _projectionFactory;
	}

	public void setPropertyFactory(PropertyFactory projectionFactory) {
		_projectionFactory = projectionFactory;
	}

	private static PropertyFactory _projectionFactory;

}