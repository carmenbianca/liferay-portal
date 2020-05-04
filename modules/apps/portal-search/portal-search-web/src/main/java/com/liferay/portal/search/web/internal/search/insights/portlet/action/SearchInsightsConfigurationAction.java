/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.search.insights.portlet.action;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.search.web.internal.search.insights.constants.SearchInsightsPortletKeys;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Wade Cao
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + SearchInsightsPortletKeys.SEARCH_INSIGHTS,
	service = ConfigurationAction.class
)
public class SearchInsightsConfigurationAction
	extends DefaultConfigurationAction {

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest) {
		PermissionChecker permissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		if (!permissionChecker.isOmniadmin()) {
			SessionErrors.add(
				httpServletRequest, PrincipalException.class.getName());

			return "/error.jsp";
		}

		return "/search/insights/configuration.jsp";
	}

}