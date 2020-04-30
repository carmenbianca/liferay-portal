/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.lock;

/**
 * @author Alexander Chow
 */
public interface LockListener {

	public String getClassName();

	public void onAfterExpire(String key);

	public void onAfterRefresh(String key);

	public void onBeforeExpire(String key);

	public void onBeforeRefresh(String key);

}