/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.portlet.action;

import com.liferay.configuration.admin.constants.ConfigurationAdminPortletKeys;
import com.liferay.configuration.admin.web.internal.constants.ConfigurationAdminWebKeys;
import com.liferay.configuration.admin.web.internal.display.ConfigurationCategorySectionDisplay;
import com.liferay.configuration.admin.web.internal.display.context.ConfigurationScopeDisplayContext;
import com.liferay.configuration.admin.web.internal.display.context.ConfigurationScopeDisplayContextFactory;
import com.liferay.configuration.admin.web.internal.util.ConfigurationEntryRetriever;
import com.liferay.configuration.admin.web.internal.util.ResourceBundleLoaderProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jorge Ferrer
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ConfigurationAdminPortletKeys.INSTANCE_SETTINGS,
		"javax.portlet.name=" + ConfigurationAdminPortletKeys.SITE_SETTINGS,
		"javax.portlet.name=" + ConfigurationAdminPortletKeys.SYSTEM_SETTINGS,
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		ConfigurationScopeDisplayContext configurationScopeDisplayContext =
			ConfigurationScopeDisplayContextFactory.create(renderRequest);

		List<ConfigurationCategorySectionDisplay>
			configurationCategorySectionDisplays =
				_configurationEntryRetriever.
					getConfigurationCategorySectionDisplays(
						configurationScopeDisplayContext.getScope(),
						configurationScopeDisplayContext.getScopePK());

		renderRequest.setAttribute(
			ConfigurationAdminWebKeys.CONFIGURATION_CATEGORY_SECTION_DISPLAYS,
			configurationCategorySectionDisplays);

		renderRequest.setAttribute(
			ConfigurationAdminWebKeys.CONFIGURATION_ENTRY_RETRIEVER,
			_configurationEntryRetriever);
		renderRequest.setAttribute(
			ConfigurationAdminWebKeys.RESOURCE_BUNDLE_LOADER_PROVIDER,
			_resourceBundleLoaderProvider);

		return "/view.jsp";
	}

	@Reference
	private ConfigurationEntryRetriever _configurationEntryRetriever;

	@Reference
	private ResourceBundleLoaderProvider _resourceBundleLoaderProvider;

}