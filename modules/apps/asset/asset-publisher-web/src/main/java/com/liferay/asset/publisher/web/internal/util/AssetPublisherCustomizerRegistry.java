/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.util;

/**
 * @author Pavel Savinov
 */
public interface AssetPublisherCustomizerRegistry {

	public AssetPublisherCustomizer getAssetPublisherCustomizer(
		String portletId);

}