/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.spring.orm;

/**
 * @author Shuyang Zhou
 */
public class LastSessionRecorderHelperUtil {

	public static void syncLastSessionState() {
		_lastSessionRecorderHelper.syncLastSessionState();
	}

	public void setLastSessionRecorderHelper(
		LastSessionRecorderHelper lastSessionRecorderHelper) {

		_lastSessionRecorderHelper = lastSessionRecorderHelper;
	}

	private static LastSessionRecorderHelper _lastSessionRecorderHelper;

}