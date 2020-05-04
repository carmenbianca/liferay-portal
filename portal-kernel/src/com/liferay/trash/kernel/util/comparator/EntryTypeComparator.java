/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.kernel.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.trash.kernel.model.TrashEntry;

/**
 * @author     Sergio González
 * @deprecated As of Judson (7.1.x), replaced by {@link
 *             com.liferay.trash.util.comparator.EntryTypeComparator}
 */
@Deprecated
public class EntryTypeComparator extends OrderByComparator<TrashEntry> {

	public static final String ORDER_BY_ASC = "classNameId ASC";

	public static final String ORDER_BY_DESC = "classNameId DESC";

	public static final String[] ORDER_BY_FIELDS = {"classNameId"};

	public EntryTypeComparator() {
		this(false);
	}

	public EntryTypeComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(TrashEntry entry1, TrashEntry entry2) {
		int value = 0;

		if (entry1.getClassNameId() > entry2.getClassNameId()) {
			value = 1;
		}
		else if (entry1.getClassNameId() < entry2.getClassNameId()) {
			value = -1;
		}

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}