/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.site.administration.internal.display.context;

import com.liferay.application.list.constants.ApplicationListWebKeys;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.application.list.display.context.logic.PanelCategoryHelper;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Pavel Savinov
 */
public class ContentPanelCategoryDisplayContext {

	public ContentPanelCategoryDisplayContext(PortletRequest portletRequest) {
		_portletRequest = portletRequest;
	}

	public DropdownItemList getScopesDropdownItemList() throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)_portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PanelCategoryHelper panelCategoryHelper =
			(PanelCategoryHelper)_portletRequest.getAttribute(
				ApplicationListWebKeys.PANEL_CATEGORY_HELPER);

		String portletId = themeDisplay.getPpid();

		if (Validator.isNull(portletId) ||
			!panelCategoryHelper.containsPortlet(
				portletId, PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
				themeDisplay.getPermissionChecker(),
				themeDisplay.getSiteGroup())) {

			portletId = panelCategoryHelper.getFirstPortletId(
				PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
				themeDisplay.getPermissionChecker(),
				themeDisplay.getSiteGroup());
		}

		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
			_portletRequest, themeDisplay.getSiteGroup(), portletId, 0, 0,
			PortletRequest.RENDER_PHASE);

		DropdownItemList dropdownItems = DropdownItemListBuilder.add(
			dropdownItem -> {
				dropdownItem.setHref(portletURL);
				dropdownItem.setLabel(
					LanguageUtil.get(
						themeDisplay.getLocale(), "default-scope"));
			}
		).build();

		List<Layout> scopeLayouts = LayoutLocalServiceUtil.getScopeGroupLayouts(
			themeDisplay.getSiteGroupId());

		for (Layout scopeLayout : scopeLayouts) {
			Group scopeGroup = scopeLayout.getScopeGroup();

			if (Validator.isNull(portletId) ||
				!panelCategoryHelper.containsPortlet(
					portletId, PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
					themeDisplay.getPermissionChecker(), scopeGroup)) {

				portletId = panelCategoryHelper.getFirstPortletId(
					PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
					themeDisplay.getPermissionChecker(), scopeGroup);
			}

			if (Validator.isNull(portletId)) {
				continue;
			}

			PortletURL layoutItemPortletURL =
				PortalUtil.getControlPanelPortletURL(
					_portletRequest, scopeGroup, portletId, 0, 0,
					PortletRequest.RENDER_PHASE);

			dropdownItems.add(
				dropdownItem -> {
					dropdownItem.setHref(layoutItemPortletURL);
					dropdownItem.setLabel(
						LanguageUtil.get(
							themeDisplay.getLocale(),
							HtmlUtil.escape(
								scopeLayout.getName(
									themeDisplay.getLocale()))));
				});
		}

		return dropdownItems;
	}

	private final PortletRequest _portletRequest;

}