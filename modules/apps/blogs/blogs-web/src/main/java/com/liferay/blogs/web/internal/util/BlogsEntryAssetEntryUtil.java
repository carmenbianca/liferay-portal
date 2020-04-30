/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.util;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.web.internal.constants.BlogsWebConstants;
import com.liferay.portal.kernel.exception.PortalException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alejandro Tardín
 */
public class BlogsEntryAssetEntryUtil {

	public static AssetEntry getAssetEntry(
			HttpServletRequest httpServletRequest, BlogsEntry blogsEntry)
		throws PortalException {

		AssetEntry assetEntry = (AssetEntry)httpServletRequest.getAttribute(
			BlogsWebConstants.BLOGS_ENTRY_ASSET_ENTRY);

		if (assetEntry == null) {
			assetEntry = AssetEntryLocalServiceUtil.getEntry(
				BlogsEntry.class.getName(), blogsEntry.getEntryId());

			httpServletRequest.setAttribute(
				BlogsWebConstants.BLOGS_ENTRY_ASSET_ENTRY, assetEntry);
		}

		return assetEntry;
	}

}