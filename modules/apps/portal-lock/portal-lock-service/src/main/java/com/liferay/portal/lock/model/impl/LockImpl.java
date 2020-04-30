/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lock.model.impl;

/**
 * @author Brian Wing Shun Chan
 */
public class LockImpl extends LockBaseImpl {

	@Override
	public long getExpirationTime() {
		if (isNeverExpires()) {
			return 0;
		}

		return getExpirationDate().getTime() - getCreateDate().getTime();
	}

	@Override
	public boolean isExpired() {
		if (isNeverExpires()) {
			return false;
		}
		else if (System.currentTimeMillis() > getExpirationDate().getTime()) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isNeverExpires() {
		if (getExpirationDate() == null) {
			return true;
		}

		return false;
	}

}