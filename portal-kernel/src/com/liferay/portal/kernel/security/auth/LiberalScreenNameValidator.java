/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author Brian Wing Shun Chan
 */
public class LiberalScreenNameValidator extends DefaultScreenNameValidator {

	@Override
	public boolean validate(long companyId, String screenName) {
		if (Validator.isNull(screenName)) {
			return false;
		}

		return true;
	}

}