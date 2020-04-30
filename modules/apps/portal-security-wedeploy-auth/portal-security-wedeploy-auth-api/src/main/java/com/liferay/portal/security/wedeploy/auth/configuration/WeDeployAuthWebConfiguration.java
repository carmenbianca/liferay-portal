/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Supritha Sundaram
 */
@ExtendedObjectClassDefinition(category = "security-tools")
@Meta.OCD(
	id = "com.liferay.portal.security.wedeploy.auth.configuration.WeDeployAuthWebConfiguration",
	localization = "content/Language",
	name = "portal-security-wedeploy-auth-web-configuration-name"
)
public interface WeDeployAuthWebConfiguration {

	@Meta.AD(
		deflt = "3600000",
		description = "authorization-token-expiration-time-help",
		name = "authorization-token-expiration-time", required = false
	)
	public long authorizationTokenExpirationTime();

}