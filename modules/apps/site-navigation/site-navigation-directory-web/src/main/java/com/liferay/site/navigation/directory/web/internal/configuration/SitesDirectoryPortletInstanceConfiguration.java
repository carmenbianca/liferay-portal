/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.directory.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Juergen Kappler
 */
@ExtendedObjectClassDefinition(
	category = "navigation",
	scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
	id = "com.liferay.site.navigation.directory.web.internal.configuration.SitesDirectoryPortletInstanceConfiguration",
	localization = "content/Language",
	name = "sites-directory-portlet-instance-configuration-name"
)
public interface SitesDirectoryPortletInstanceConfiguration {

	@Meta.AD(deflt = "top-level", name = "sites", required = false)
	public String sites();

	@Meta.AD(deflt = "descriptive", name = "display-style", required = false)
	public String displayStyle();

}