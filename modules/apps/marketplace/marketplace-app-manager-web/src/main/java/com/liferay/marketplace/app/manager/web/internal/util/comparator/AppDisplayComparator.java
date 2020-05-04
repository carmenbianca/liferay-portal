/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.app.manager.web.internal.util.comparator;

import com.liferay.marketplace.app.manager.web.internal.util.AppDisplay;

import java.util.Comparator;

/**
 * @author Ryan Park
 */
public class AppDisplayComparator implements Comparator<AppDisplay> {

	public AppDisplayComparator(String orderByType) {
		if (!orderByType.equals("asc")) {
			_ascending = false;
		}
		else {
			_ascending = true;
		}
	}

	@Override
	public int compare(AppDisplay appDisplay1, AppDisplay appDisplay2) {
		int value = appDisplay1.compareTo(appDisplay2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	private final boolean _ascending;

}