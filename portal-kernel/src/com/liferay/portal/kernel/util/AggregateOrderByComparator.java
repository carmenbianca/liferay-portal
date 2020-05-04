/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.petra.string.StringPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Carlos Sierra Andrés
 */
public class AggregateOrderByComparator<T> extends OrderByComparator<T> {

	public AggregateOrderByComparator(
		List<OrderByComparator<T>> orderByComparators) {

		_orderByComparators = new ArrayList<>(orderByComparators);
	}

	public AggregateOrderByComparator(
		OrderByComparator<T>... orderByComparators) {

		_orderByComparators = new ArrayList<>(
			Arrays.asList(orderByComparators));
	}

	@Override
	public int compare(T t1, T t2) {
		for (OrderByComparator<T> orderByComparators : _orderByComparators) {
			int value = orderByComparators.compare(t1, t2);

			if (value != 0) {
				return value;
			}
		}

		return 0;
	}

	@Override
	public String getOrderBy() {
		return StringUtil.merge(
			ListUtil.toList(_orderByComparators, OrderByComparator::getOrderBy),
			StringPool.COMMA);
	}

	@Override
	public Comparator<T> reversed() {
		return Collections.reverseOrder(this);
	}

	private final List<OrderByComparator<T>> _orderByComparators;

}