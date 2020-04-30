/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.display.web.internal.portlet;

import com.liferay.asset.display.web.internal.constants.AssetDisplayPortletKeys;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.PreviewPortletProvider;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.asset.kernel.model.AssetEntry",
	service = PreviewPortletProvider.class
)
public class AssetDisplayPreviewPortletProvider
	extends BasePortletProvider implements PreviewPortletProvider {

	@Override
	public String getPortletName() {
		return AssetDisplayPortletKeys.ASSET_DISPLAY;
	}

}