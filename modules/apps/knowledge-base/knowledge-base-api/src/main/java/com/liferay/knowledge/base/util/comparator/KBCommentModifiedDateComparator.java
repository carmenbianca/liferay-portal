/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.util.comparator;

import com.liferay.knowledge.base.model.KBComment;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Sergio González
 */
public class KBCommentModifiedDateComparator
	extends OrderByComparator<KBComment> {

	public static final String ORDER_BY_ASC = "KBComment.modifiedDate ASC";

	public static final String ORDER_BY_DESC = "KBComment.modifiedDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"modifiedDate"};

	public KBCommentModifiedDateComparator() {
		this(false);
	}

	public KBCommentModifiedDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(KBComment kbComment1, KBComment kbComment2) {
		int value = DateUtil.compareTo(
			kbComment1.getModifiedDate(), kbComment2.getModifiedDate());

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