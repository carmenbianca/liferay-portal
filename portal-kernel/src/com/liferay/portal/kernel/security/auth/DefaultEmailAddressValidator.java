/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author Shinn Lok
 */
public class DefaultEmailAddressValidator implements EmailAddressValidator {

	@Override
	public boolean validate(long companyId, String emailAddress) {
		if (!Validator.isEmailAddress(emailAddress) ||
			emailAddress.startsWith("postmaster@") ||
			emailAddress.startsWith("root@")) {

			return false;
		}

		return true;
	}

}