/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.display.page.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Jorge García Jiménez
 */
@ExtendedObjectClassDefinition(category = "assets")
@Meta.OCD(
	id = "com.liferay.asset.display.page.configuration.AssetDisplayPageConfiguration",
	localization = "content/Language",
	name = "asset-display-page-configuration-name"
)
public interface AssetDisplayPageConfiguration {

	@Meta.AD(
		deflt = "false", name = "enable-view-count-increment", required = false
	)
	public boolean enableViewCountIncrement();

}