/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.common.spi.service.context;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Víctor Galán
 */
public class ServiceContextUtil {

	public static ServiceContext createServiceContext(
		long groupId, String viewableBy) {

		return createServiceContext(
			new Long[0], new String[0], groupId, viewableBy);
	}

	public static ServiceContext createServiceContext(
		Long[] assetCategoryIds, String[] assetTagNames, Long groupId,
		String viewableBy) {

		return createServiceContext(
			assetCategoryIds, assetTagNames, null, groupId, viewableBy);
	}

	public static ServiceContext createServiceContext(
		Long[] assetCategoryIds, String[] assetTagNames,
		Map<String, Serializable> expandoBridgeAttributes, Long groupId,
		String viewableBy) {

		ServiceContext serviceContext = new ServiceContext();

		if (StringUtil.equalsIgnoreCase(viewableBy, "anyone")) {
			serviceContext.setAddGuestPermissions(true);
			serviceContext.setAddGroupPermissions(true);
		}
		else if (StringUtil.equalsIgnoreCase(viewableBy, "members")) {
			serviceContext.setAddGuestPermissions(false);
			serviceContext.setAddGroupPermissions(true);
		}
		else {
			serviceContext.setAddGuestPermissions(false);
			serviceContext.setAddGroupPermissions(false);
		}

		if (assetCategoryIds != null) {
			serviceContext.setAssetCategoryIds(
				ArrayUtil.toArray(assetCategoryIds));
		}

		if (assetTagNames != null) {
			serviceContext.setAssetTagNames(assetTagNames);
		}

		if (expandoBridgeAttributes != null) {
			serviceContext.setExpandoBridgeAttributes(expandoBridgeAttributes);
		}

		if (groupId != null) {
			serviceContext.setScopeGroupId(groupId);
		}

		return serviceContext;
	}

	public static ServiceContext createServiceContext(
		Map<String, Serializable> expandoBridgeAttributes, long groupId,
		String viewableBy) {

		return createServiceContext(
			new Long[0], new String[0], expandoBridgeAttributes, groupId,
			viewableBy);
	}

}