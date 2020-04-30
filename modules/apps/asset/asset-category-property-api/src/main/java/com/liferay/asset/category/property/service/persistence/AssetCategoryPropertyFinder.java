/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.category.property.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface AssetCategoryPropertyFinder {

	public int countByG_K(long groupId, String key);

	public java.util.List
		<com.liferay.asset.category.property.model.AssetCategoryProperty>
			findByG_K(long groupId, String key);

	public java.util.List
		<com.liferay.asset.category.property.model.AssetCategoryProperty>
			findByG_K(long groupId, String key, int start, int end);

}