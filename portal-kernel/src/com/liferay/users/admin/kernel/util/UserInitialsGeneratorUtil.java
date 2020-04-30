/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.kernel.util;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

import java.util.Locale;

/**
 * @author Drew Brokke
 */
public class UserInitialsGeneratorUtil {

	public static String getInitials(
		Locale locale, String firstName, String middleName, String lastName) {

		return _userInitialsGenerator.getInitials(
			locale, firstName, middleName, lastName);
	}

	public static String getInitials(User user) {
		return _userInitialsGenerator.getInitials(user);
	}

	private static volatile UserInitialsGenerator _userInitialsGenerator =
		ServiceProxyFactory.newServiceTrackedInstance(
			UserInitialsGenerator.class, UserInitialsGeneratorUtil.class,
			"_userInitialsGenerator", false);

}