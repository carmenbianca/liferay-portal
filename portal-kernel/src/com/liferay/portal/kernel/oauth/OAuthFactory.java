/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.oauth;

/**
 * @author Brian Wing Shun Chan
 */
public interface OAuthFactory {

	public OAuthManager createOAuthManager(
			String key, String secret, String accessURL, String requestURL,
			String callbackURL, String scope)
		throws OAuthException;

	public OAuthRequest createOAuthRequest(Verb verb, String url)
		throws OAuthException;

	public Token createToken(String token, String secret) throws OAuthException;

	public Verifier createVerifier(String verifier) throws OAuthException;

}