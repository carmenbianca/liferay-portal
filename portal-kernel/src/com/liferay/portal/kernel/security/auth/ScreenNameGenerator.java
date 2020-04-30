/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public interface ScreenNameGenerator {

	public String generate(long companyId, long userId, String emailAddress)
		throws Exception;

}