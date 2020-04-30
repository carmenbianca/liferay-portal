/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.util;

import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.asset.util.AssetEntryQueryProcessor;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public interface AssetPublisherCustomizer {

	public Integer getDelta(HttpServletRequest httpServletRequest);

	public String getPortletId();

	public boolean isEnablePermissions(HttpServletRequest httpServletRequest);

	public boolean isOrderingAndGroupingEnabled(
		HttpServletRequest httpServletRequest);

	public boolean isOrderingByTitleEnabled(
		HttpServletRequest httpServletRequest);

	public boolean isSelectionStyleEnabled(
		HttpServletRequest httpServletRequest);

	public boolean isShowAssetEntryQueryProcessor(
		AssetEntryQueryProcessor assetEntryQueryProcessor);

	public boolean isShowEnableAddContentButton(
		HttpServletRequest httpServletRequest);

	public boolean isShowEnableRelatedAssets(
		HttpServletRequest httpServletRequest);

	public boolean isShowScopeSelector(HttpServletRequest httpServletRequest);

	public boolean isShowSubtypeFieldsFilter(
		HttpServletRequest httpServletRequest);

	public void setAssetEntryQueryOptions(
		AssetEntryQuery assetEntryQuery, HttpServletRequest httpServletRequest);

}