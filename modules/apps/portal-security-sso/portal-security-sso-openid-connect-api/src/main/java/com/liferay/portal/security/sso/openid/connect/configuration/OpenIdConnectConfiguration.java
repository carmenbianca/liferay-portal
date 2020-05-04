/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.connect.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * Defines the configuration property keys and default values.
 *
 * <p>
 * This class also defines the identity of the configuration schema which, among
 * other things, defines the filename (minus the <code>.cfg</code> extension)
 * for setting values via a file.
 * </p>
 *
 * @author Thuong Dinh
 */
@ExtendedObjectClassDefinition(category = "sso")
@Meta.OCD(
	id = "com.liferay.portal.security.sso.openid.connect.configuration.OpenIdConnectConfiguration",
	localization = "content/Language",
	name = "open-id-connect-configuration-name"
)
public interface OpenIdConnectConfiguration {

	@Meta.AD(
		deflt = "false", description = "enabled-help", name = "enabled",
		required = false
	)
	public boolean enabled();

}