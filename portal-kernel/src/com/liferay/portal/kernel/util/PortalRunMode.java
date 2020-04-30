/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

/**
 * @author Michael C. Han
 */
public class PortalRunMode {

	public static boolean isTestMode() {
		String liferayMode = SystemProperties.get("liferay.mode");

		if (Validator.isNotNull(liferayMode) && liferayMode.equals("test")) {
			return true;
		}

		return false;
	}

}