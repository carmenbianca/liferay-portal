/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.browser.web.internal.search;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;

import javax.portlet.RenderResponse;

/**
 * @author Jürgen Kappler
 */
public class AddAssetEntryChecker extends EmptyOnClickRowChecker {

	public AddAssetEntryChecker(
		RenderResponse renderResponse, long assetEntryId) {

		super(renderResponse);

		_assetEntryId = assetEntryId;
	}

	@Override
	public boolean isDisabled(Object obj) {
		AssetEntry assetEntry = (AssetEntry)obj;

		if (assetEntry.getEntryId() == _assetEntryId) {
			return true;
		}

		return super.isDisabled(obj);
	}

	private final long _assetEntryId;

}