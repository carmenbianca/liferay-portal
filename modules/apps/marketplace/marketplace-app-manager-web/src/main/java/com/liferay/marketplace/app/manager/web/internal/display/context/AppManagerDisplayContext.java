/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.app.manager.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemListBuilder;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pei-Jung Lan
 */
public class AppManagerDisplayContext {

	public AppManagerDisplayContext(
		HttpServletRequest httpServletRequest, RenderResponse renderResponse) {

		_httpServletRequest = httpServletRequest;
		_renderResponse = renderResponse;
	}

	public List<NavigationItem> getModuleNavigationItems() {
		String pluginType = ParamUtil.getString(
			_httpServletRequest, "pluginType", "components");

		return NavigationItemListBuilder.add(
			navigationItem -> {
				navigationItem.setActive(pluginType.equals("components"));
				navigationItem.setHref(_getViewModuleURL("components"));
				navigationItem.setLabel(
					LanguageUtil.get(_httpServletRequest, "components"));
			}
		).add(
			navigationItem -> {
				navigationItem.setActive(pluginType.equals("portlets"));
				navigationItem.setHref(_getViewModuleURL("portlets"));
				navigationItem.setLabel(
					LanguageUtil.get(_httpServletRequest, "portlets"));
			}
		).build();
	}

	public List<NavigationItem> getNavigationItems(String url, String label) {
		return NavigationItemListBuilder.add(
			navigationItem -> {
				navigationItem.setActive(true);
				navigationItem.setHref(url);
				navigationItem.setLabel(
					LanguageUtil.get(_httpServletRequest, label));
			}
		).build();
	}

	private String _getViewModuleURL(String pluginType) {
		String app = ParamUtil.getString(_httpServletRequest, "app");
		String moduleGroup = ParamUtil.getString(
			_httpServletRequest, "moduleGroup");
		String symbolicName = ParamUtil.getString(
			_httpServletRequest, "symbolicName");
		String version = ParamUtil.getString(_httpServletRequest, "version");

		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/view_module.jsp");
		portletURL.setParameter("app", app);
		portletURL.setParameter("moduleGroup", moduleGroup);
		portletURL.setParameter("symbolicName", symbolicName);
		portletURL.setParameter("version", version);
		portletURL.setParameter("pluginType", pluginType);

		return portletURL.toString();
	}

	private final HttpServletRequest _httpServletRequest;
	private final RenderResponse _renderResponse;

}