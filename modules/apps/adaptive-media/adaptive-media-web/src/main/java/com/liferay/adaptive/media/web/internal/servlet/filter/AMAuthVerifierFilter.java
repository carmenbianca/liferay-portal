/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.web.internal.servlet.filter;

import com.liferay.adaptive.media.web.internal.constants.AMWebConstants;
import com.liferay.portal.servlet.filters.authverifier.AuthVerifierFilter;

import javax.servlet.Filter;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"filter.init.auth.verifier.PortalSessionAuthVerifier.check.csrf.token=false",
		"filter.init.auth.verifier.PortalSessionAuthVerifier.urls.includes=/" + AMWebConstants.SERVLET_PATH + "/*",
		"osgi.http.whiteboard.filter.name=com.liferay.adaptive.media.web.internal.servlet.filter.AMAuthVerifierFilter",
		"osgi.http.whiteboard.filter.pattern=/" + AMWebConstants.SERVLET_PATH + "/*"
	},
	service = Filter.class
)
public class AMAuthVerifierFilter extends AuthVerifierFilter {
}