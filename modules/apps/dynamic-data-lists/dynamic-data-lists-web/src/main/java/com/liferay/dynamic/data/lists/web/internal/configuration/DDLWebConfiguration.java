/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Lino Alves
 */
@ExtendedObjectClassDefinition(category = "dynamic-data-lists")
@Meta.OCD(
	id = "com.liferay.dynamic.data.lists.web.internal.configuration.DDLWebConfiguration",
	localization = "content/Language", name = "ddl-web-configuration-name"
)
public interface DDLWebConfiguration {

	@Meta.AD(
		deflt = "false",
		description = "changeable-default-language-description",
		name = "changeable-default-language", required = false
	)
	public boolean changeableDefaultLanguage();

	@Meta.AD(
		deflt = "enabled-with-warning", name = "csv-export",
		optionLabels = {"enabled", "enabled-with-warning", "disabled"},
		optionValues = {"enabled", "enabled-with-warning", "disabled"},
		required = false
	)
	public String csvExport();

	@Meta.AD(
		deflt = "list", name = "default-display-view",
		optionLabels = {"%list", "%table"},
		optionValues = {"descriptive", "list"}, required = false
	)
	public String defaultDisplayView();

}