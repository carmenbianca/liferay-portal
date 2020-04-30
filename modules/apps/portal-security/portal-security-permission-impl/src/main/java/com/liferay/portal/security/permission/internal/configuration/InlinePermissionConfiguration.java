/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.permission.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Sergio González
 */
@ExtendedObjectClassDefinition(category = "security-tools")
@Meta.OCD(
	id = "com.liferay.portal.security.permission.internal.configuration.InlinePermissionConfiguration",
	localization = "content/Language",
	name = "inline-permission-configuration-name"
)
public interface InlinePermissionConfiguration {

	/**
	 * Set this to <code>true</code> to enable inline SQL permission checks.
	 */
	@Meta.AD(deflt = "true", name = "sql-check-enabled", required = false)
	public boolean sqlCheckEnabled();

}