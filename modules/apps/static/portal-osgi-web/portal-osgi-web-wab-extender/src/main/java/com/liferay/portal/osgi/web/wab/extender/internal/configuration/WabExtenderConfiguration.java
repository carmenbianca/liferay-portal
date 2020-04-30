/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.wab.extender.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Iván Zaera
 */
@ExtendedObjectClassDefinition(category = "module-container")
@Meta.OCD(
	id = "com.liferay.portal.osgi.web.wab.extender.internal.configuration.WabExtenderConfiguration",
	localization = "content/Language", name = "wab-extender-configuration-name"
)
public interface WabExtenderConfiguration {

	@Meta.AD(deflt = "60000", name = "stop-timeout", required = false)
	public long stopTimeout();

}