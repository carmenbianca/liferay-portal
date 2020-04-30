/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactory;

/**
 * @author Brian Wing Shun Chan
 */
public class OrderFactoryImpl implements OrderFactory {

	@Override
	public Order asc(String propertyName) {
		return new OrderImpl(org.hibernate.criterion.Order.asc(propertyName));
	}

	@Override
	public Order desc(String propertyName) {
		return new OrderImpl(org.hibernate.criterion.Order.desc(propertyName));
	}

}