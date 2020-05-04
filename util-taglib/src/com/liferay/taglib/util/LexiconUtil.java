/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.util;

import com.liferay.portal.kernel.model.User;

/**
 * @author Eudaldo Alonso
 */
public class LexiconUtil {

	public static String getUserColorCssClass(User user) {
		if (user == null) {
			return "user-icon-default";
		}

		return "user-icon-color-".concat(
			_NUMBERS[(int)(user.getUserId() % 10)]);
	}

	private static final String[] _NUMBERS = {
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
	};

}