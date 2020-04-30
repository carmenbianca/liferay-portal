/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.oauth;

/**
 * @author Brian Wing Shun Chan
 */
public interface OAuthRequest {

	public void addBodyParameter(String key, String value);

	public String getURL();

	public Verb getVerb();

	public Object getWrappedOAuthRequest();

	public OAuthResponse send() throws OAuthException;

}