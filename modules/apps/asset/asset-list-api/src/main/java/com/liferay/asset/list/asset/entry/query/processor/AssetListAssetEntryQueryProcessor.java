/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.asset.entry.query.processor;

import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Sarai Díaz
 */
public interface AssetListAssetEntryQueryProcessor {

	public void processAssetEntryQuery(
		String userId, UnicodeProperties unicodeProperties,
		AssetEntryQuery assetEntryQuery);

}