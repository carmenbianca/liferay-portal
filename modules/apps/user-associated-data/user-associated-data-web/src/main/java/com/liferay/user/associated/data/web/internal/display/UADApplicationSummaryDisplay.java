/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.web.internal.display;

/**
 * @author Drew Brokke
 */
public class UADApplicationSummaryDisplay {

	public String getApplicationKey() {
		return _applicationKey;
	}

	public int getCount() {
		return _count;
	}

	public boolean hasItems() {
		if (getCount() > 0) {
			return true;
		}

		return false;
	}

	public void setApplicationKey(String applicationKey) {
		_applicationKey = applicationKey;
	}

	public void setCount(int count) {
		_count = count;
	}

	private String _applicationKey;
	private int _count;

}