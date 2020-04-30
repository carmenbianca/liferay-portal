/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.component.blacklist.internal;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Michael C. Han
 */
@ExtendedObjectClassDefinition(category = "module-container")
@Meta.OCD(
	id = "com.liferay.portal.component.blacklist.internal.ComponentBlacklistConfiguration",
	localization = "content/Language",
	name = "component-blacklist-configuration-name"
)
public interface ComponentBlacklistConfiguration {

	@Meta.AD(
		deflt = "", description = "blacklist-component-names-help",
		name = "blacklist-component-names", required = false
	)
	public String[] blacklistComponentNames();

}