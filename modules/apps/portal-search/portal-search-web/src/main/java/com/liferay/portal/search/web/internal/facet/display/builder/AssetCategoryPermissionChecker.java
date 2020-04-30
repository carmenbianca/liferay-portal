/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.facet.display.builder;

import com.liferay.asset.kernel.model.AssetCategory;

/**
 * @author André de Oliveira
 */
public interface AssetCategoryPermissionChecker {

	public boolean hasPermission(AssetCategory assetCategory);

}