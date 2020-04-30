/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import java.util.Locale;

/**
 * @author Michael C. Han
 */
public interface FullNameGenerator {

	public String getFullName(
		String firstName, String middleName, String lastName);

	public String getLocalizedFullName(
		String firstName, String middleName, String lastName, Locale locale,
		long prefixId, long suffixId);

	public String[] splitFullName(String fullName);

}