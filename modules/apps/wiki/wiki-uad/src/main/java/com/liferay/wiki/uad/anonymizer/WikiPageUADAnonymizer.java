/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.uad.anonymizer;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.user.associated.data.anonymizer.UADAnonymizer;
import com.liferay.wiki.model.WikiPage;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = UADAnonymizer.class)
public class WikiPageUADAnonymizer extends BaseWikiPageUADAnonymizer {

	@Override
	protected AssetEntry fetchAssetEntry(WikiPage wikiPage) {
		return assetEntryLocalService.fetchEntry(
			WikiPage.class.getName(), wikiPage.getResourcePrimKey());
	}

}