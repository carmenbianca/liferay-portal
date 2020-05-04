/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.test.util;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.model.ClassedModel;

/**
 * @author Cristina González
 */
public class DefaultWhenIsAssetable implements WhenIsAssetable {

	@Override
	public AssetEntry fetchAssetEntry(ClassedModel classedModel)
		throws Exception {

		Class<?> modelClass = classedModel.getModelClass();

		return AssetEntryLocalServiceUtil.fetchEntry(
			modelClass.getName(), (Long)classedModel.getPrimaryKeyObj());
	}

	@Override
	public boolean isAssetEntryVisible(ClassedModel classedModel, long classPK)
		throws Exception {

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
			classedModel.getModelClassName(), classPK);

		return assetEntry.isVisible();
	}

}