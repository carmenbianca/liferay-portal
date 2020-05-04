/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util.comparator;

import com.liferay.portal.kernel.model.UserTracker;
import com.liferay.portal.kernel.util.DateUtil;

import java.io.Serializable;

import java.util.Comparator;

/**
 * @author Brian Wing Shun Chan
 */
public class UserTrackerModifiedDateComparator
	implements Comparator<UserTracker>, Serializable {

	public UserTrackerModifiedDateComparator() {
		this(false);
	}

	public UserTrackerModifiedDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(UserTracker userTracker1, UserTracker userTracker2) {
		int value = DateUtil.compareTo(
			userTracker1.getModifiedDate(), userTracker2.getModifiedDate());

		if (_ascending) {
			return value;
		}

		return -value;
	}

	private final boolean _ascending;

}