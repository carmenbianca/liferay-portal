/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Cristina González
 */
@ExtendedObjectClassDefinition(
	category = "pages", scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
@Meta.OCD(
	description = "layout-seo-configuration-description",
	id = "com.liferay.layout.seo.internal.configuration.LayoutSEOCompanyConfiguration",
	localization = "content/Language", name = "layout-seo-configuration-name"
)
public interface LayoutSEOCompanyConfiguration {

	/**
	 * Sets the configuration type to use with the localized URL.
	 */
	@Meta.AD(
		deflt = "default-language-url",
		description = "layout-seo-configuration-canonical-url-description",
		name = "layout-seo-configuration-canonical-url",
		optionLabels = {
			"layout-seo-configuration-page-default-language-url",
			"layout-seo-configuration-page-localized-url"
		},
		optionValues = {"default-language-url", "localized-url"},
		required = false
	)
	public String canonicalURL();

	/**
	 * Sets if open graph is enabled.
	 */
	@Meta.AD(
		deflt = "true",
		description = "layout-seo-configuration-enable-open-graph-description",
		name = "layout-seo-configuration-enable-open-graph", required = false
	)
	public boolean enableOpenGraph();

}