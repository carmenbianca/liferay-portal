/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.display.page.test.util;

import com.liferay.asset.display.page.model.AssetDisplayPageEntry;
import com.liferay.asset.display.page.service.AssetDisplayPageEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.TestPropsValues;

/**
 * @author Jürgen Kappler
 */
public class AssetDisplayPageEntryTestUtil {

	public static AssetDisplayPageEntry addAssetDisplayPageEntry(
			long groupId, long classNameId, long classPK,
			long layoutPageTemplateEntryId, int type)
		throws PortalException {

		return AssetDisplayPageEntryLocalServiceUtil.addAssetDisplayPageEntry(
			TestPropsValues.getUserId(), groupId, classNameId, classPK,
			layoutPageTemplateEntryId, type, new ServiceContext());
	}

	public static AssetDisplayPageEntry addDefaultAssetDisplayPageEntry(
			long groupId, long classNameId, long classPK,
			long layoutPageTemplateEntryId)
		throws PortalException {

		return AssetDisplayPageEntryLocalServiceUtil.addAssetDisplayPageEntry(
			TestPropsValues.getUserId(), groupId, classNameId, classPK,
			layoutPageTemplateEntryId, new ServiceContext());
	}

}