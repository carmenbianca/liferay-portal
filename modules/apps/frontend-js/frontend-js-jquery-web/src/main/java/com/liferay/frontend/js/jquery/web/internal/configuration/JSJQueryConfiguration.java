/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.js.jquery.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Julien Castelain
 * @review
 */
@ExtendedObjectClassDefinition(category = "third-party")
@Meta.OCD(
	description = "frontend-js-jquery-description",
	id = "com.liferay.frontend.js.jquery.web.internal.configuration.JSJQueryConfiguration",
	localization = "content/Language",
	name = "frontend-js-jquery-configuration-name"
)
public interface JSJQueryConfiguration {

	/**
	 * Set this to <code>true</code> to enable JQuery usage.
	 *
	 * @return <code>true</code> if JQuery is enabled.
	 * @review
	 */
	@Meta.AD(deflt = "false", name = "enable-jquery", required = false)
	public boolean enableJQuery();

}