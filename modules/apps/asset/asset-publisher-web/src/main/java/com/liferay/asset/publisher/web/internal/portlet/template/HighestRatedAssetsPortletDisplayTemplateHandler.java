/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.portlet.template;

import com.liferay.asset.publisher.constants.AssetPublisherPortletKeys;
import com.liferay.portal.kernel.template.TemplateHandler;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + AssetPublisherPortletKeys.HIGHEST_RATED_ASSETS,
	service = TemplateHandler.class
)
public class HighestRatedAssetsPortletDisplayTemplateHandler
	extends AssetPublisherPortletDisplayTemplateHandler {
}