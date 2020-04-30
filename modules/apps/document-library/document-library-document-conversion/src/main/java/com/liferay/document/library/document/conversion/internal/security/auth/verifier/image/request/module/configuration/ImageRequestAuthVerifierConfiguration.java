/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.document.conversion.internal.security.auth.verifier.image.request.module.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author István András Dézsi
 */
@ExtendedObjectClassDefinition(category = "api-authentication")
@Meta.OCD(
	id = "com.liferay.document.library.document.conversion.internal.security.auth.verifier.image.request.module.configuration.ImageRequestAuthVerifierConfiguration",
	localization = "content/Language",
	name = "image-request-auth-verifier-configuration-name"
)
public interface ImageRequestAuthVerifierConfiguration {

	@Meta.AD(deflt = "true", name = "enabled", required = false)
	public boolean enabled();

	@Meta.AD(name = "hosts-allowed", required = false)
	public String hostsAllowed();

	@Meta.AD(name = "urls-excludes", required = false)
	public String urlsExcludes();

	@Meta.AD(name = "urls-includes", required = false)
	public String urlsIncludes();

}