/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.servlet.taglib.ui;

import com.liferay.asset.publisher.constants.AssetPublisherConstants;
import com.liferay.asset.publisher.web.internal.util.AssetPublisherCustomizer;
import com.liferay.asset.publisher.web.internal.util.AssetPublisherCustomizerRegistry;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.PortletLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorEntry;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	property = "form.navigator.entry.order:Integer=50",
	service = FormNavigatorEntry.class
)
public class GroupingFormNavigatorEntry
	extends BaseConfigurationFormNavigatorEntry {

	@Override
	public String getCategoryKey() {
		return AssetPublisherConstants.CATEGORY_KEY_DISPLAY_SETTINGS;
	}

	@Override
	public String getKey() {
		return "grouping";
	}

	@Override
	public boolean isVisible(User user, Object object) {
		if (!isDynamicAssetSelection()) {
			return false;
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		Portlet portlet = _portletLocalService.getPortletById(
			themeDisplay.getCompanyId(), portletDisplay.getPortletResource());

		AssetPublisherCustomizer assetPublisherCustomizer =
			assetPublisherCustomizerRegistry.getAssetPublisherCustomizer(
				portlet.getRootPortletId());

		if (assetPublisherCustomizer == null) {
			return true;
		}

		return assetPublisherCustomizer.isOrderingAndGroupingEnabled(
			serviceContext.getRequest());
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.asset.publisher.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	@Override
	protected String getJspPath() {
		return "/configuration/grouping.jsp";
	}

	@Reference
	protected AssetPublisherCustomizerRegistry assetPublisherCustomizerRegistry;

	@Reference
	private PortletLocalService _portletLocalService;

}