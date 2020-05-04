/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.membership.requests.kernel.util.comparator;

import com.liferay.portal.kernel.model.MembershipRequest;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Eudaldo Alonso
 */
public class MembershipRequestCreateDateComparator
	extends OrderByComparator<MembershipRequest> {

	public static final String ORDER_BY_ASC =
		"MembershipRequest.createDate ASC";

	public static final String ORDER_BY_DESC =
		"MembershipRequest.createDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"createDate"};

	public MembershipRequestCreateDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		MembershipRequest membershipRequest1,
		MembershipRequest membershipRequest2) {

		int value = DateUtil.compareTo(
			membershipRequest1.getCreateDate(),
			membershipRequest2.getCreateDate());

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