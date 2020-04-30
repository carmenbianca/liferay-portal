/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.util;

import com.liferay.asset.kernel.model.AssetRendererFactory;

/**
 * @author André de Oliveira
 */
public interface AssetRendererFactoryLookup {

	public AssetRendererFactory<?> getAssetRendererFactoryByClassName(
		String className);

	public AssetRendererFactory<?> getAssetRendererFactoryByType(String type);

}