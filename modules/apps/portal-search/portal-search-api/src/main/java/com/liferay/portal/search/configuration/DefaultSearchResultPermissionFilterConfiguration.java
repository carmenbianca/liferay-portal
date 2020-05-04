/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Eric Yan
 */
@ExtendedObjectClassDefinition(category = "search")
@Meta.OCD(
	id = "com.liferay.portal.search.configuration.DefaultSearchResultPermissionFilterConfiguration",
	localization = "content/Language",
	name = "default-search-result-permission-filter-configuration-name"
)
@ProviderType
public interface DefaultSearchResultPermissionFilterConfiguration {

	@Meta.AD(
		deflt = "0",
		description = "permission-filtered-search-result-accurate-count-threshold-help",
		name = "permission-filtered-search-result-accurate-count-threshold",
		required = false
	)
	public int permissionFilteredSearchResultAccurateCountThreshold();

	@Meta.AD(
		deflt = "1000", description = "search-query-result-window-limit-help",
		name = "search-query-result-window-limit", required = false
	)
	public int searchQueryResultWindowLimit();

}