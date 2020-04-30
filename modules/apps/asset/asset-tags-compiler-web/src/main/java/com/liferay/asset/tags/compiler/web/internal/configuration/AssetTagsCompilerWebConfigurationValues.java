/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.tags.compiler.web.internal.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Jürgen Kappler
 */
public class AssetTagsCompilerWebConfigurationValues {

	public static final boolean ENABLED = GetterUtil.getBoolean(
		AssetTagsCompilerWebConfigurationUtil.get("enabled"));

}