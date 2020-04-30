/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.tags.navigation.web.internal.portlet.route;

import com.liferay.asset.tags.navigation.constants.AssetTagsNavigationPortletKeys;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jürgen Kappler
 */
@Component(
	property = {
		"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
		"javax.portlet.name=" + AssetTagsNavigationPortletKeys.ASSET_TAGS_CLOUD
	},
	service = FriendlyURLMapper.class
)
public class AssetTagsCloudFriendlyURLMapper
	extends BaseAssetTagsFriendlyURLMapper {
}