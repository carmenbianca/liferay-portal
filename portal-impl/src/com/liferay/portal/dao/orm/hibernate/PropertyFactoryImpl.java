/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactory;

/**
 * @author Brian Wing Shun Chan
 */
public class PropertyFactoryImpl implements PropertyFactory {

	@Override
	public Property forName(String propertyName) {
		return new PropertyImpl(
			org.hibernate.criterion.Property.forName(propertyName));
	}

}