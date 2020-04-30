/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.test.util;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.model.ClassedModel;

/**
 * @author Cristina González
 */
public interface WhenIsAssetable {

	public AssetEntry fetchAssetEntry(ClassedModel classedModel)
		throws Exception;

	public boolean isAssetEntryVisible(ClassedModel classedModel, long classPK)
		throws Exception;

}