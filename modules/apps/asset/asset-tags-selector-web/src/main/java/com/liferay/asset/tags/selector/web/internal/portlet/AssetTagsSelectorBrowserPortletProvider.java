/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.tags.selector.web.internal.portlet;

import com.liferay.asset.tags.selector.web.internal.contants.AssetTagsSelectorPortletKeys;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.BrowsePortletProvider;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.asset.kernel.model.AssetTag",
	service = BrowsePortletProvider.class
)
public class AssetTagsSelectorBrowserPortletProvider
	extends BasePortletProvider implements BrowsePortletProvider {

	@Override
	public String getPortletName() {
		return AssetTagsSelectorPortletKeys.ASSET_TAGS_SELECTOR;
	}

}