/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util.comparator;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Brian Wing Shun Chan
 */
public class UserEmailAddressComparator extends OrderByComparator<User> {

	public static final String ORDER_BY_ASC = "emailAddress ASC";

	public static final String ORDER_BY_DESC = "emailAddress DESC";

	public static final String[] ORDER_BY_FIELDS = {"emailAddress"};

	public UserEmailAddressComparator() {
		this(false);
	}

	public UserEmailAddressComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(User user1, User user2) {
		String emailAddress1 = user1.getEmailAddress();
		String emailAddress2 = user2.getEmailAddress();

		int value = emailAddress1.compareTo(emailAddress2);

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