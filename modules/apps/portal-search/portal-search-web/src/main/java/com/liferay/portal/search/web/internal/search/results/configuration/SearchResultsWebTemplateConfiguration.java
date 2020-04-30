/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.search.results.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Kevin Tan
 */
@ExtendedObjectClassDefinition(category = "search")
@Meta.OCD(
	id = "com.liferay.portal.search.web.internal.search.results.configuration.SearchResultsWebTemplateConfiguration",
	localization = "content/Language",
	name = "search-results-web-template-configuration-name"
)
public interface SearchResultsWebTemplateConfiguration {

	@Meta.AD(
		deflt = "search-results-list-ftl",
		name = "search-results-template-key-default", required = false
	)
	public String searchResultsTemplateKeyDefault();

}