/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Marcellus Tavares
 */
@ExtendedObjectClassDefinition(category = "template-engines")
@Meta.OCD(
	id = "com.liferay.portal.template.soy.internal.configuration.SoyTemplateEngineConfiguration",
	localization = "content/Language",
	name = "soy-template-engine-configuration-name"
)
public interface SoyTemplateEngineConfiguration {

	@Meta.AD(
		deflt = "60", name = "resource-modification-check", required = false
	)
	public int resourceModificationCheck();

}