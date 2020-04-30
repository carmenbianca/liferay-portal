/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.xsl.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Peter Fellwock
 */
@ExtendedObjectClassDefinition(category = "template-engines")
@Meta.OCD(
	id = "com.liferay.portal.template.xsl.configuration.XSLEngineConfiguration",
	localization = "content/Language", name = "xsl-engine-configuration-name"
)
public interface XSLEngineConfiguration {

	@Meta.AD(
		deflt = "true", name = "prevent-local-connections", required = false
	)
	public boolean preventLocalConnections();

	@Meta.AD(
		deflt = "true", name = "secure-processing-enabled", required = false
	)
	public boolean secureProcessingEnabled();

}