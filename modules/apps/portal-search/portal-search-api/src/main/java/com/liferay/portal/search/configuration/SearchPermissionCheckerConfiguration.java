/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ExtendedObjectClassDefinition(category = "search")
@Meta.OCD(
	id = "com.liferay.portal.search.configuration.SearchPermissionCheckerConfiguration",
	localization = "content/Language",
	name = "search-permission-checker-configuration-name"
)
@ProviderType
public interface SearchPermissionCheckerConfiguration {

	@Meta.AD(
		deflt = "250", description = "permission-terms-limit-help",
		name = "permission-terms-limit", required = false
	)
	public int permissionTermsLimit();

}