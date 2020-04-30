/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.oauth;

/**
 * @author Brian Wing Shun Chan
 */
public interface OAuthResponse {

	public String getBody();

	public int getStatus();

	public Object getWrappedOAuthResponse();

}