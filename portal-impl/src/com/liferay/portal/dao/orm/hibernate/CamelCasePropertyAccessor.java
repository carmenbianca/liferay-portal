/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

/**
 * @author Brian Wing Shun Chan
 */
public class CamelCasePropertyAccessor extends LiferayPropertyAccessor {

	@Override
	protected String formatPropertyName(String propertyName) {
		if (propertyName.length() < 3) {
			return super.formatPropertyName(propertyName);
		}

		char c0 = propertyName.charAt(0);
		char c1 = propertyName.charAt(1);
		char c2 = propertyName.charAt(2);

		if (Character.isLowerCase(c0) && Character.isUpperCase(c1) &&
			Character.isLowerCase(c2)) {

			propertyName =
				Character.toUpperCase(c0) + propertyName.substring(1);
		}

		return super.formatPropertyName(propertyName);
	}

}