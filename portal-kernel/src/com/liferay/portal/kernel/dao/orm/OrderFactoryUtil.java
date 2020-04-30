/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Brian Wing Shun Chan
 */
public class OrderFactoryUtil {

	public static void addOrderByComparator(
		DynamicQuery dynamicQuery, OrderByComparator<?> obc) {

		if (obc == null) {
			return;
		}

		String[] orderByFields = obc.getOrderByFields();

		for (String orderByField : orderByFields) {
			if (obc.isAscending(orderByField)) {
				dynamicQuery.addOrder(asc(orderByField));
			}
			else {
				dynamicQuery.addOrder(desc(orderByField));
			}
		}
	}

	public static Order asc(String propertyName) {
		return getOrderFactory().asc(propertyName);
	}

	public static Order desc(String propertyName) {
		return getOrderFactory().desc(propertyName);
	}

	public static OrderFactory getOrderFactory() {
		return _orderFactory;
	}

	public void setOrderFactory(OrderFactory orderFactory) {
		_orderFactory = orderFactory;
	}

	private static OrderFactory _orderFactory;

}