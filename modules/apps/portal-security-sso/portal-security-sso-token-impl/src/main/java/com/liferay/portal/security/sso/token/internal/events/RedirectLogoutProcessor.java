/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.token.internal.events;

import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.token.events.LogoutProcessor;
import com.liferay.portal.security.sso.token.events.LogoutProcessorType;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = "logout.processor.type=" + LogoutProcessorType.REDIRECT,
	service = LogoutProcessor.class
)
public class RedirectLogoutProcessor implements LogoutProcessor {

	@Override
	public void logout(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String... parameters)
		throws IOException {

		if (ArrayUtil.isEmpty(parameters)) {
			return;
		}

		String pathInfo = httpServletRequest.getPathInfo();

		if (pathInfo.contains("/portal/logout")) {
			HttpSession session = httpServletRequest.getSession();

			session.invalidate();

			String redirectURL = parameters[0];

			if (Validator.isNotNull(redirectURL)) {
				httpServletResponse.sendRedirect(redirectURL);
			}
		}
	}

}