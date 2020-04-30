/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lar;

/**
 * @author Bruno Farache
 */
public interface UserIdStrategy {

	public static final String ALWAYS_CURRENT_USER_ID =
		"ALWAYS_CURRENT_USER_ID";

	public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

	public long getUserId(String userUuid);

}