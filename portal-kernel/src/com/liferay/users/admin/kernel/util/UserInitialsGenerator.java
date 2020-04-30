/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.kernel.util;

import com.liferay.portal.kernel.model.User;

import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Pei-Jung Lan
 */
@ProviderType
public interface UserInitialsGenerator {

	public String getInitials(
		Locale locale, String firstName, String middleName, String lastName);

	public String getInitials(User user);

}