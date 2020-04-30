/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.token.security.auth;

/**
 * @author Michael C. Han
 */
public final class TokenLocation {

	public static final String COOKIE = "COOKIE";

	public static final String REQUEST = "REQUEST";

	public static final String REQUEST_HEADER = "REQUEST_HEADER";

	public static final String SESSION = "SESSION";

}