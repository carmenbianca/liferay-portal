/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Adam Brandizzi
 * @author André de Oliveira
 */
@ExtendedObjectClassDefinition(category = "search")
@Meta.OCD(
	id = "com.liferay.portal.search.web.internal.configuration.SearchWebConfiguration",
	localization = "content/Language", name = "search-web-configuration-name"
)
public interface SearchWebConfiguration {

	@Meta.AD(
		description = "classic-search-widget-in-front-page-help",
		name = "classic-search-widget-in-front-page", required = false
	)
	public boolean classicSearchPortletInFrontPage();

}