/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.opener.google.drive.web.internal.oauth;

import com.liferay.document.library.opener.google.drive.web.internal.constants.DLOpenerGoogleDriveWebConstants;
import com.liferay.document.library.opener.oauth.OAuth2State;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Alicia Garcia Garcia
 */
public class OAuth2StateUtil {

	public static void cleanUp(HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession();

		httpSession.removeAttribute(
			_SESSION_ATTRIBUTE_NAME_GOOGLE_OAUTH2_STATE);
	}

	public static Optional<OAuth2State> getOAuth2StateOptional(
		HttpServletRequest httpServletRequest) {

		HttpSession httpSession = httpServletRequest.getSession();

		return Optional.ofNullable(
			(OAuth2State)httpSession.getAttribute(
				_SESSION_ATTRIBUTE_NAME_GOOGLE_OAUTH2_STATE));
	}

	public static String getRedirectURI(String portalURL) {
		return portalURL + Portal.PATH_MODULE +
			DLOpenerGoogleDriveWebConstants.GOOGLE_DRIVE_SERVLET_PATH;
	}

	public static boolean isValid(
		OAuth2State oAuth2State, HttpServletRequest httpServletRequest) {

		if (Validator.isNotNull(
				ParamUtil.getString(httpServletRequest, "error"))) {

			return false;
		}

		String state = ParamUtil.getString(httpServletRequest, "state");

		return oAuth2State.isValid(state);
	}

	public static void save(
		HttpServletRequest httpServletRequest, OAuth2State oAuth2State) {

		HttpSession httpSession = httpServletRequest.getSession();

		httpSession.setAttribute(
			_SESSION_ATTRIBUTE_NAME_GOOGLE_OAUTH2_STATE, oAuth2State);
	}

	private static final String _SESSION_ATTRIBUTE_NAME_GOOGLE_OAUTH2_STATE =
		"google-oauth2-state";

}