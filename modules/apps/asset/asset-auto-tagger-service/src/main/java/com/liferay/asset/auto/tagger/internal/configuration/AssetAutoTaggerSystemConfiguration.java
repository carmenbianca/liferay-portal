/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.auto.tagger.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Alejandro Tardín
 */
@ExtendedObjectClassDefinition(category = "assets")
@Meta.OCD(
	id = "com.liferay.asset.auto.tagger.internal.configuration.AssetAutoTaggerSystemConfiguration",
	localization = "content/Language",
	name = "asset-auto-tagger-configuration-name"
)
public interface AssetAutoTaggerSystemConfiguration {

	/**
	 * Enables asset auto tagging.
	 */
	@Meta.AD(deflt = "true", name = "enabled", required = false)
	public boolean enabled();

	/**
	 * Specifies the maximum number of tags that can be added for a given asset.
	 */
	@Meta.AD(
		description = "system-maximum-number-of-tags-per-asset-description",
		name = "maximum-number-of-tags-per-asset", required = false
	)
	public int maximumNumberOfTagsPerAsset();

}