/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.password.policies.admin.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemListBuilder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.PasswordPolicyPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pei-Jung Lan
 */
public class PasswordPolicyDisplayContext {

	public PasswordPolicyDisplayContext(
		HttpServletRequest httpServletRequest, RenderResponse renderResponse) {

		_httpServletRequest = httpServletRequest;
		_renderResponse = renderResponse;

		_passwordPolicyId = ParamUtil.getLong(
			_httpServletRequest, "passwordPolicyId");

		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		_permissionChecker = themeDisplay.getPermissionChecker();
	}

	public List<NavigationItem> getEditPasswordPolicyAssignmentsNavigationItems(
		PortletURL portletURL) {

		String tabs2 = ParamUtil.getString(
			_httpServletRequest, "tabs2", "users");

		return NavigationItemListBuilder.add(
			navigationItem -> {
				navigationItem.setActive(tabs2.equals("users"));
				navigationItem.setHref(portletURL, "tabs2", "users");
				navigationItem.setLabel(
					LanguageUtil.get(_httpServletRequest, "users"));
			}
		).add(
			navigationItem -> {
				navigationItem.setActive(tabs2.equals("organizations"));
				navigationItem.setHref(portletURL, "tabs2", "organizations");
				navigationItem.setLabel(
					LanguageUtil.get(_httpServletRequest, "organizations"));
			}
		).build();
	}

	public List<NavigationItem> getEditPasswordPolicyNavigationItems()
		throws PortletException {

		String tabs1 = ParamUtil.getString(
			_httpServletRequest, "tabs1", "details");
		String redirect = ParamUtil.getString(_httpServletRequest, "redirect");

		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("redirect", redirect);
		portletURL.setParameter(
			"passwordPolicyId", String.valueOf(_passwordPolicyId));

		List<NavigationItem> navigationItems = NavigationItemListBuilder.add(
			() -> (_passwordPolicyId == 0) || _hasPermission(ActionKeys.UPDATE),
			navigationItem -> {
				navigationItem.setActive(tabs1.equals("details"));

				PortletURL detailsURL = PortletURLUtil.clone(
					portletURL, _renderResponse);

				detailsURL.setParameter("mvcPath", "/edit_password_policy.jsp");
				detailsURL.setParameter("tabs1", "details");

				navigationItem.setHref(detailsURL.toString());

				navigationItem.setLabel(
					LanguageUtil.get(_httpServletRequest, "details"));
			}
		).add(
			() -> _hasPermission(ActionKeys.ASSIGN_MEMBERS),
			navigationItem -> {
				navigationItem.setActive(tabs1.equals("assignees"));

				PortletURL assigneesURL = PortletURLUtil.clone(
					portletURL, _renderResponse);

				assigneesURL.setParameter(
					"mvcPath", "/edit_password_policy_assignments.jsp");
				assigneesURL.setParameter("tabs1", "assignees");

				navigationItem.setHref(assigneesURL.toString());

				navigationItem.setLabel(
					LanguageUtil.get(_httpServletRequest, "assignees"));
			}
		).build();

		if (navigationItems.isEmpty()) {
			return null;
		}

		return navigationItems;
	}

	public List<NavigationItem> getSelectMembersNavigationItems() {
		String tabs2 = ParamUtil.getString(
			_httpServletRequest, "tabs2", "users");

		List<NavigationItem> navigationItems = new ArrayList<>();

		NavigationItem entriesNavigationItem = new NavigationItem();

		entriesNavigationItem.setActive(true);
		entriesNavigationItem.setHref(StringPool.BLANK);
		entriesNavigationItem.setLabel(
			LanguageUtil.get(_httpServletRequest, tabs2));

		navigationItems.add(entriesNavigationItem);

		return navigationItems;
	}

	public List<NavigationItem> getViewPasswordPoliciesNavigationItems() {
		List<NavigationItem> navigationItems = new ArrayList<>();

		NavigationItem entriesNavigationItem = new NavigationItem();

		entriesNavigationItem.setActive(true);
		entriesNavigationItem.setHref(StringPool.BLANK);
		entriesNavigationItem.setLabel(
			LanguageUtil.get(_httpServletRequest, "password-policies"));

		navigationItems.add(entriesNavigationItem);

		return navigationItems;
	}

	public boolean hasPermission(String actionId, long passwordPolicyId) {
		return _hasPermission(actionId, passwordPolicyId);
	}

	private boolean _hasPermission(String actionId) {
		return _hasPermission(actionId, _passwordPolicyId);
	}

	private boolean _hasPermission(String actionId, long passwordPolicyId) {
		if (passwordPolicyId <= 0) {
			return false;
		}

		return PasswordPolicyPermissionUtil.contains(
			_permissionChecker, passwordPolicyId, actionId);
	}

	private final HttpServletRequest _httpServletRequest;
	private final Long _passwordPolicyId;
	private final PermissionChecker _permissionChecker;
	private final RenderResponse _renderResponse;

}