/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.lock;

/**
 * @author Alexander Chow
 */
public abstract class BaseLockListener implements LockListener {

	@Override
	public void onAfterExpire(String key) {
	}

	@Override
	public void onAfterRefresh(String key) {
	}

	@Override
	public void onBeforeExpire(String key) {
	}

	@Override
	public void onBeforeRefresh(String key) {
	}

}