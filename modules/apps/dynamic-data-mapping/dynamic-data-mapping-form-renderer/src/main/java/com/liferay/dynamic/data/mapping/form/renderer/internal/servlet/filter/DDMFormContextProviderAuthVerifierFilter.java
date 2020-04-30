/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.renderer.internal.servlet.filter;

import com.liferay.portal.servlet.filters.authverifier.AuthVerifierFilter;

import javax.servlet.Filter;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rafael Praxedes
 */
@Component(
	immediate = true,
	property = {
		"filter.init.auth.verifier.PortalSessionAuthVerifier.check.csrf.token=false",
		"filter.init.auth.verifier.PortalSessionAuthVerifier.urls.includes=/dynamic-data-mapping-form-context-provider/*",
		"osgi.http.whiteboard.filter.name=com.liferay.dynamic.data.mapping.form.renderer.internal.servlet.filter.DDMFormContextProviderAuthVerifierFilter",
		"osgi.http.whiteboard.filter.pattern=/dynamic-data-mapping-form-context-provider/*"
	},
	service = Filter.class
)
public class DDMFormContextProviderAuthVerifierFilter
	extends AuthVerifierFilter {
}