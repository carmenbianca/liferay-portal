/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.tags.internal.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Máté Thurzó
 */
public class AssetTagsServiceConfigurationValues {

	public static final boolean STAGING_MERGE_TAGS_BY_NAME =
		GetterUtil.getBoolean(
			AssetTagsServiceConfigurationUtil.get(
				AssetTagsServiceConfigurationKeys.STAGING_MERGE_TAGS_BY_NAME));

}