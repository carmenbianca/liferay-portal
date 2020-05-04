/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.tags.internal.search.spi.model.index.contributor;

import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Luan Maoski
 * @author Lucas Marques
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.asset.kernel.model.AssetTag",
	service = ModelDocumentContributor.class
)
public class AssetTagModelDocumentContributor
	implements ModelDocumentContributor<AssetTag> {

	@Override
	public void contribute(Document document, AssetTag assetTag) {
		document.addTextSortable(Field.NAME, assetTag.getName());

		document.addNumberSortable("assetCount", assetTag.getAssetCount());
	}

}