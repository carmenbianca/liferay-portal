/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.sso;

/**
 * @author Raymond Augé
 */
public interface SSO {

	public String getSessionExpirationRedirectUrl(long companyId);

	public String getSignInURL(long companyId, String defaultSignInURL);

	public boolean isLoginRedirectRequired(long companyId);

	public boolean isRedirectRequired(long companyId);

	public boolean isSessionRedirectOnExpire(long companyId);

}