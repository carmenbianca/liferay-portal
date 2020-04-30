/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

/**
 * @author Amos Fong
 */
public class DefaultFullNameValidator implements FullNameValidator {

	@Override
	public boolean validate(
		long companyId, String firstName, String middleName, String lastName) {

		return true;
	}

}