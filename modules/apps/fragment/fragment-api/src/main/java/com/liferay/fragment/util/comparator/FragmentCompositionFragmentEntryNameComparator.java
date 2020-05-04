/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.util.comparator;

import com.liferay.fragment.model.FragmentComposition;
import com.liferay.fragment.model.FragmentEntry;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Pavel Savinov
 */
public class FragmentCompositionFragmentEntryNameComparator
	extends OrderByComparator<Object> {

	public static final String ORDER_BY_ASC = "name ASC";

	public static final String ORDER_BY_DESC = "name DESC";

	public static final String[] ORDER_BY_FIELDS = {"name"};

	public FragmentCompositionFragmentEntryNameComparator() {
		this(false);
	}

	public FragmentCompositionFragmentEntryNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object object1, Object object2) {
		String name1 = getName(object1);
		String name2 = getName(object2);

		int value = name1.compareTo(name2);

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

	protected String getName(Object object) {
		if (object instanceof FragmentComposition) {
			FragmentComposition fragmentComposition =
				(FragmentComposition)object;

			return fragmentComposition.getName();
		}

		FragmentEntry fragmentEntry = (FragmentEntry)object;

		return fragmentEntry.getName();
	}

	private final boolean _ascending;

}