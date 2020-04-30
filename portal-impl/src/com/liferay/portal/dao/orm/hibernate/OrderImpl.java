/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.Order;

/**
 * @author Brian Wing Shun Chan
 */
public class OrderImpl implements Order {

	public OrderImpl(org.hibernate.criterion.Order order) {
		_order = order;
	}

	public org.hibernate.criterion.Order getWrappedOrder() {
		return _order;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{_order=");
		sb.append(String.valueOf(_order));
		sb.append("}");

		return sb.toString();
	}

	private final org.hibernate.criterion.Order _order;

}