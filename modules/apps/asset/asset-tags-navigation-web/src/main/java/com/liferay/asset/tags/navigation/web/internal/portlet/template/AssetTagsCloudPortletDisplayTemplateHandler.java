/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.tags.navigation.web.internal.portlet.template;

import com.liferay.asset.tags.navigation.constants.AssetTagsNavigationPortletKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + AssetTagsNavigationPortletKeys.ASSET_TAGS_CLOUD,
	service = TemplateHandler.class
)
public class AssetTagsCloudPortletDisplayTemplateHandler
	extends AssetTagsNavigationPortletDisplayTemplateHandler {

	@Override
	public String getName(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		String portletTitle = portal.getPortletTitle(
			AssetTagsNavigationPortletKeys.ASSET_TAGS_CLOUD, resourceBundle);

		return LanguageUtil.format(locale, "x-template", portletTitle, false);
	}

	@Override
	public String getResourceName() {
		return AssetTagsNavigationPortletKeys.ASSET_TAGS_CLOUD;
	}

}