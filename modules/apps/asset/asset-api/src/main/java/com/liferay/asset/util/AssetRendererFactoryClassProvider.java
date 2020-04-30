/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.util;

import com.liferay.asset.kernel.model.AssetRendererFactory;

/**
 * @author Alejandro Tardín
 */
public interface AssetRendererFactoryClassProvider {

	public Class<? extends AssetRendererFactory> getClass(
		AssetRendererFactory assetRendererFactory);

}