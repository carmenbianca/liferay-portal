/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.test.util;

import com.liferay.asset.kernel.model.AssetEntry;

/**
 * Provides a utility method to convert an asset entry to XML format so it can
 * be saved in the Asset Publisher's portlet preferences.
 *
 * @author Tamas Molnar
 */
public class AssetPublisherTestUtil {

	public static String getAssetEntryXml(AssetEntry assetEntry) {
		StringBuilder sb = new StringBuilder(6);

		sb.append("<?xml version=\"1.0\"?><asset-entry>");
		sb.append("<asset-entry-type>");
		sb.append(assetEntry.getClassName());
		sb.append("</asset-entry-type><asset-entry-uuid>");
		sb.append(assetEntry.getClassUuid());
		sb.append("</asset-entry-uuid></asset-entry>");

		return sb.toString();
	}

}