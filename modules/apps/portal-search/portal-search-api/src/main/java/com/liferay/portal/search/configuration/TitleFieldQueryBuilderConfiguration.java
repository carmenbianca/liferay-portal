/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 */
@ExtendedObjectClassDefinition(category = "search")
@Meta.OCD(
	id = "com.liferay.portal.search.configuration.TitleFieldQueryBuilderConfiguration",
	localization = "content/Language",
	name = "title-field-query-builder-configuration-name"
)
@ProviderType
public interface TitleFieldQueryBuilderConfiguration {

	@Meta.AD(
		deflt = "2.0", description = "exact-match-boost-help",
		name = "exact-match-boost", required = false
	)
	public float exactMatchBoost();

	@Meta.AD(
		deflt = "50", description = "max-expansions-help",
		name = "max-expansions", required = false
	)
	public int maxExpansions();

}