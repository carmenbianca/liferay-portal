/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.asset.model.adapter.builder;

import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.asset.kernel.model.adapter.StagedAssetLink;
import com.liferay.portal.kernel.model.adapter.builder.ModelAdapterBuilder;
import com.liferay.portlet.asset.model.adapter.impl.StagedAssetLinkImpl;

/**
 * @author Máté Thurzó
 */
public class StagedAssetLinkModelAdapterBuilder
	implements ModelAdapterBuilder<AssetLink, StagedAssetLink> {

	@Override
	public StagedAssetLink build(AssetLink assetLink) {
		return new StagedAssetLinkImpl(assetLink);
	}

}