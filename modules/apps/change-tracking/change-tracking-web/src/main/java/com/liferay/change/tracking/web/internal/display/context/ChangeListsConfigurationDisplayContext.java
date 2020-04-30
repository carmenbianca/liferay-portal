/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.web.internal.display.context;

import com.liferay.change.tracking.model.CTPreferences;
import com.liferay.change.tracking.service.CTPreferencesLocalService;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemListBuilder;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Máté Thurzó
 * @author Samuel Trong Tran
 */
public class ChangeListsConfigurationDisplayContext {

	public ChangeListsConfigurationDisplayContext(
		CTPreferencesLocalService ctPreferencesLocalService,
		HttpServletRequest httpServletRequest, Language language,
		RenderResponse renderResponse) {

		_httpServletRequest = httpServletRequest;

		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		CTPreferences ctPreferences =
			ctPreferencesLocalService.fetchCTPreferences(
				themeDisplay.getCompanyId(), 0);

		if (ctPreferences != null) {
			_changeListsEnabled = true;
		}
		else {
			_changeListsEnabled = false;
		}

		_language = language;
		_renderResponse = renderResponse;
	}

	public String getActionURL() {
		PortletURL actionURL = _renderResponse.createActionURL();

		actionURL.setParameter(
			ActionRequest.ACTION_NAME,
			"/change_lists/update_global_change_lists_configuration");

		return actionURL.toString();
	}

	public String getNavigation() {
		if (_navigation != null) {
			return _navigation;
		}

		if (isChangeListsEnabled()) {
			_navigation = ParamUtil.getString(
				_httpServletRequest, "navigation", "global-settings");
		}
		else {
			_navigation = "global-settings";
		}

		return _navigation;
	}

	public List<NavigationItem> getViewNavigationItems() {
		return NavigationItemListBuilder.add(
			navigationItem -> {
				String navigation = getNavigation();

				navigationItem.setActive(navigation.equals("global-settings"));

				navigationItem.setHref(
					_renderResponse.createRenderURL(), "navigation",
					"global-settings");
				navigationItem.setLabel(
					_language.get(_httpServletRequest, "global-settings"));
			}
		).build();
	}

	public boolean isChangeListsEnabled() {
		return _changeListsEnabled;
	}

	private final boolean _changeListsEnabled;
	private final HttpServletRequest _httpServletRequest;
	private final Language _language;
	private String _navigation;
	private final RenderResponse _renderResponse;

}