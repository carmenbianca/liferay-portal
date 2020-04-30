/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

/**
 * @author Wesley Gong
 */
public interface EmailAddressGenerator {

	public String generate(long companyId, long userId);

	public boolean isFake(String emailAddress);

	public boolean isGenerated(String emailAddress);

}