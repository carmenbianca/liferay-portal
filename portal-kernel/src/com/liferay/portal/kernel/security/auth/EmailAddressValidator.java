/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

/**
 * @author Shinn Lok
 */
public interface EmailAddressValidator {

	public boolean validate(long companyId, String emailAddress);

}