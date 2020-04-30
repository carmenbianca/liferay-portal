/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import java.util.Locale;

/**
 * @author Brian Wing Shun Chan
 */
public interface ScreenNameValidator {

	public String getAUIValidatorJS();

	public String getDescription(Locale locale);

	public boolean validate(long companyId, String screenName);

}