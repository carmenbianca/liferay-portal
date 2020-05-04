/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.tag.facet.portlet.action;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.search.web.internal.facet.display.builder.AssetTagsSearchFacetDisplayBuilder;
import com.liferay.portal.search.web.internal.tag.facet.constants.TagFacetPortletKeys;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Lino Alves
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + TagFacetPortletKeys.TAG_FACET,
	service = ConfigurationAction.class
)
public class TagFacetConfigurationAction extends DefaultConfigurationAction {

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest) {
		return "/tag/facet/configuration.jsp";
	}

	@Override
	public void include(
			PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		RenderRequest renderRequest =
			(RenderRequest)httpServletRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_REQUEST);

		AssetTagsSearchFacetDisplayBuilder assetTagsSearchFacetDisplayBuilder =
			createAssetTagsSearchFacetDisplayBuilder(renderRequest);

		httpServletRequest.setAttribute(
			WebKeys.PORTLET_DISPLAY_CONTEXT,
			assetTagsSearchFacetDisplayBuilder.build());

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	protected AssetTagsSearchFacetDisplayBuilder
		createAssetTagsSearchFacetDisplayBuilder(RenderRequest renderRequest) {

		try {
			return new AssetTagsSearchFacetDisplayBuilder(renderRequest);
		}
		catch (ConfigurationException configurationException) {
			throw new RuntimeException(configurationException);
		}
	}

}