/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.oauth;

import com.liferay.portal.kernel.oauth.OAuthException;
import com.liferay.portal.kernel.oauth.OAuthManager;
import com.liferay.portal.kernel.oauth.OAuthRequest;
import com.liferay.portal.kernel.oauth.Token;
import com.liferay.portal.kernel.oauth.Verifier;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.OAuthConstants;
import org.scribe.oauth.OAuthService;

/**
 * @author Brian Wing Shun Chan
 */
public class OAuthManagerImpl implements OAuthManager {

	public OAuthManagerImpl(
		String key, String secret, final String accessURL,
		final String requestURL, String callbackURL, String scope) {

		Api api = new DefaultApi10a() {

			@Override
			public String getAccessTokenEndpoint() {
				return accessURL;
			}

			@Override
			public String getRequestTokenEndpoint() {
				return requestURL;
			}

		};

		if (callbackURL == null) {
			callbackURL = OAuthConstants.OUT_OF_BAND;
		}

		_oAuthService = api.createService(key, secret, callbackURL, scope);
	}

	@Override
	public Token getAccessToken(Token requestToken, Verifier verifier)
		throws OAuthException {

		try {
			return new TokenImpl(
				_oAuthService.getAccessToken(
					(org.scribe.model.Token)requestToken.getWrappedToken(),
					(org.scribe.model.Verifier)verifier.getWrappedVerifier()));
		}
		catch (Exception exception) {
			throw new OAuthException(exception);
		}
	}

	@Override
	public Token getRequestToken() throws OAuthException {
		try {
			return new TokenImpl(_oAuthService.getRequestToken());
		}
		catch (Exception exception) {
			throw new OAuthException(exception);
		}
	}

	@Override
	public String getVersion() throws OAuthException {
		try {
			return _oAuthService.getVersion();
		}
		catch (Exception exception) {
			throw new OAuthException(exception);
		}
	}

	@Override
	public void signRequest(Token accessToken, OAuthRequest oAuthRequest)
		throws OAuthException {

		try {
			_oAuthService.signRequest(
				(org.scribe.model.Token)accessToken.getWrappedToken(),
				(org.scribe.model.OAuthRequest)
					oAuthRequest.getWrappedOAuthRequest());
		}
		catch (Exception exception) {
			throw new OAuthException(exception);
		}
	}

	private final OAuthService _oAuthService;

}