/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.auto.tagger.configuration;

/**
 * @author Alejandro Tardín
 */
public interface AssetAutoTaggerConfiguration {

	public int getMaximumNumberOfTagsPerAsset();

	public boolean isAvailable();

	public boolean isEnabled();

}