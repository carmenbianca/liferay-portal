/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.categories.internal.search;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;

import org.osgi.service.component.annotations.Component;

/**
 * @author Luan Maoski
 * @author Lucas Marques
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.asset.kernel.model.AssetCategory",
	service = BaseSearcher.class
)
public class AssetCategorySearcher extends BaseSearcher {

	public static final String CLASS_NAME = AssetCategory.class.getName();

	public AssetCategorySearcher() {
		setDefaultSelectedFieldNames(
			Field.ASSET_CATEGORY_ID, Field.COMPANY_ID, Field.GROUP_ID,
			Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}