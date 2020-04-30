/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.entry.processor.freemarker.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Pavel Savinov
 */
@ExtendedObjectClassDefinition(
	category = "page-fragments",
	scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
@Meta.OCD(
	id = "com.liferay.fragment.entry.processor.freemarker.internal.configuration.FreeMarkerFragmentEntryProcessorConfiguration",
	localization = "content/Language",
	name = "freemarker-fragment-entry-processor-configuration-name"
)
public interface FreeMarkerFragmentEntryProcessorConfiguration {

	@Meta.AD(
		deflt = "true", description = "enable-freemarker-help",
		id = "enable.freemarker", name = "enable-freemarker", required = false
	)
	public boolean enable();

}