/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.scope.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.oauth2.provider.scope.internal.constants.OAuth2ProviderScopeConstants;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Stian Sigvartsen
 */
@ExtendedObjectClassDefinition(
	category = "oauth2",
	factoryInstanceLabelAttribute = OAuth2ProviderScopeConstants.OSGI_JAXRS_NAME
)
@Meta.OCD(
	factory = true,
	id = "com.liferay.oauth2.provider.scope.internal.configuration.ScopeLocatorConfiguration",
	localization = "content/Language",
	name = "oauth2-scope-locator-configuration-name"
)
public interface ScopeLocatorConfiguration {

	@Meta.AD(
		deflt = "Default", description = "osgi-jaxrs-name-description",
		id = OAuth2ProviderScopeConstants.OSGI_JAXRS_NAME,
		name = "osgi-jaxrs-name", required = false
	)
	public String osgiJaxRsName();

	@Meta.AD(
		deflt = "true",
		description = "include-scopes-implied-before-scope-mapping-description",
		id = "include.scopes.implied.before.scope.mapping",
		name = "include-scopes-implied-before-scope-mapping", required = false
	)
	public boolean includeScopesImpliedBeforeScopeMapping();

}