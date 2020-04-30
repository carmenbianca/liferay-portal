/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth.verifier.internal.request.parameter.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.security.auth.verifier.internal.configuration.BaseAuthVerifierConfiguration;

/**
 * @author Tomas Polesovsky
 */
@ExtendedObjectClassDefinition(
	category = "api-authentication",
	factoryInstanceLabelAttribute = "urlsIncludes"
)
@Meta.OCD(
	factory = true,
	id = "com.liferay.portal.security.auth.verifier.internal.request.parameter.configuration.RequestParameterAuthVerifierConfiguration",
	localization = "content/Language",
	name = "request-parameter-auth-verifier-configuration-name"
)
public interface RequestParameterAuthVerifierConfiguration
	extends BaseAuthVerifierConfiguration {
}