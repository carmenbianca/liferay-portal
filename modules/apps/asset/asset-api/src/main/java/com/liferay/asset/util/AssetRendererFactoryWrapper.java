/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.util;

import com.liferay.asset.kernel.model.AssetRendererFactory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Alejandro Tardín
 */
@ProviderType
public interface AssetRendererFactoryWrapper<T>
	extends AssetRendererFactory<T> {

	public Class<? extends AssetRendererFactory> getWrappedClass();

}