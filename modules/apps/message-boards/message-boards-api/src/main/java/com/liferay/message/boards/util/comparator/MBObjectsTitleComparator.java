/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.util.comparator;

import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.model.MBThread;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author     Adolfo Pérez
 * @deprecated As of Mueller (7.2.x), replaced by {@link MBObjectsComparator}
 * @review
 */
@Deprecated
public class MBObjectsTitleComparator<T> extends OrderByComparator<T> {

	public static final String ORDER_BY_ASC =
		"modelCategory ASC, priority DESC, name ASC, modifiedDate DESC, " +
			"modelId ASC";

	public static final String ORDER_BY_DESC =
		"modelCategory ASC, priority DESC, name DESC, modifiedDate DESC, " +
			"modelId ASC";

	public static final String[] ORDER_BY_FIELDS = {
		"modelCategory", "priority", "name", "modifiedDate", "modelId"
	};

	public MBObjectsTitleComparator() {
		this(false);
	}

	public MBObjectsTitleComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(T t1, T t2) {
		String name1 = StringUtil.toLowerCase(getMBObjectsTitle(t1));
		String name2 = StringUtil.toLowerCase(getMBObjectsTitle(t2));

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

	protected String getMBObjectsTitle(Object obj) {
		if (obj instanceof MBCategory) {
			MBCategory mbCategory = (MBCategory)obj;

			return mbCategory.getName();
		}

		if (obj instanceof MBThread) {
			MBThread mbThread = (MBThread)obj;

			return mbThread.getTitle();
		}

		return null;
	}

	private final boolean _ascending;

}