/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.internal.util;

import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.util.AssetRendererFactoryClassProvider;
import com.liferay.asset.util.AssetRendererFactoryWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(service = AssetRendererFactoryClassProvider.class)
public class AssetRendererFactoryClassProviderImpl
	implements AssetRendererFactoryClassProvider {

	@Override
	public Class<? extends AssetRendererFactory> getClass(
		AssetRendererFactory assetRendererFactory) {

		if (assetRendererFactory instanceof AssetRendererFactoryWrapper) {
			AssetRendererFactoryWrapper assetRendererFactoryWrapper =
				(AssetRendererFactoryWrapper)assetRendererFactory;

			return assetRendererFactoryWrapper.getWrappedClass();
		}

		return assetRendererFactory.getClass();
	}

}