/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Wesley Gong
 */
public class DefaultEmailAddressGenerator implements EmailAddressGenerator {

	@Override
	public String generate(long companyId, long userId) {
		return userId + UserConstants.USERS_EMAIL_ADDRESS_AUTO_SUFFIX;
	}

	@Override
	public boolean isFake(String emailAddress) {
		if (Validator.isNull(emailAddress) ||
			StringUtil.endsWith(
				emailAddress, UserConstants.USERS_EMAIL_ADDRESS_AUTO_SUFFIX)) {

			return true;
		}

		return false;
	}

	@Override
	public boolean isGenerated(String emailAddress) {
		return isFake(emailAddress);
	}

}