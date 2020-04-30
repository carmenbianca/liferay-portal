/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.staging;

/**
 * @author Máté Thurzó
 */
public class StagingGroupHelperUtil {

	public static StagingGroupHelper getStagingGroupHelper() {
		if (_stagingGroupHelper != null) {
			return _stagingGroupHelper;
		}

		throw new NullPointerException("StagingGroupHelper is null");
	}

	public static void setStagingGroupHelper(
		StagingGroupHelper stagingGroupHelper) {

		if (_stagingGroupHelper != null) {
			stagingGroupHelper = _stagingGroupHelper;

			return;
		}

		_stagingGroupHelper = stagingGroupHelper;
	}

	private static StagingGroupHelper _stagingGroupHelper;

}