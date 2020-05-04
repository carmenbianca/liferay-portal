/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.bundle.blacklist.internal;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Matthew Tambara
 */
@ExtendedObjectClassDefinition(category = "module-container")
@Meta.OCD(
	id = "com.liferay.portal.bundle.blacklist.internal.BundleBlacklistConfiguration",
	localization = "content/Language",
	name = "portal-bundle-blacklist-service-configuration-name"
)
public interface BundleBlacklistConfiguration {

	@Meta.AD(
		deflt = "", name = "blacklist-bundle-symbolic-names", required = false
	)
	public String[] blacklistBundleSymbolicNames();

}