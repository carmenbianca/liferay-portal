/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.js.aui.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Iván Zaera Avellón
 * @author Marko Cikos
 */
@ExtendedObjectClassDefinition(category = "third-party")
@Meta.OCD(
	description = "frontend-js-aui-configuration-description",
	id = "com.liferay.frontend.js.aui.web.internal.configuration.AUIConfiguration",
	localization = "content/Language",
	name = "frontend-js-aui-configuration-name"
)
public interface AUIConfiguration {

	/**
	 * Set this to <code>true</code> to preload widely used AUI modules.
	 *
	 * @return <code>true</code> if widely used AUI modules should be preloaded.
	 * @review
	 */
	@Meta.AD(
		deflt = "true", description = "enable-aui-preload-description",
		name = "enable-aui-preload", required = false
	)
	public boolean enableAUIPreload();

}