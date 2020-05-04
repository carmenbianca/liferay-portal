/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

import com.liferay.portal.kernel.security.auth.verifier.AuthVerifierResult;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tomas Polesovsky
 * @author Raymond Augé
 */
public class AccessControlContext {

	public AuthVerifierResult getAuthVerifierResult() {
		return _authVerifierResult;
	}

	public HttpServletRequest getRequest() {
		return _httpServletRequest;
	}

	public HttpServletResponse getResponse() {
		return _httpServletResponse;
	}

	public Map<String, Object> getSettings() {
		return _settings;
	}

	public void setAuthVerifierResult(AuthVerifierResult authVerifierResult) {
		_authVerifierResult = authVerifierResult;
	}

	public void setRequest(HttpServletRequest httpServletRequest) {
		_httpServletRequest = httpServletRequest;
	}

	public void setResponse(HttpServletResponse httpServletResponse) {
		_httpServletResponse = httpServletResponse;
	}

	public static enum Settings {

		SERVICE_DEPTH

	}

	private AuthVerifierResult _authVerifierResult;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private final Map<String, Object> _settings = new HashMap<>();

}