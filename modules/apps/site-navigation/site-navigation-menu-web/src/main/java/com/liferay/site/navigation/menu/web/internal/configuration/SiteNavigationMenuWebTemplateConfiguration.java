/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.menu.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Juergen Kappler
 */
@ExtendedObjectClassDefinition(category = "navigation")
@Meta.OCD(
	id = "com.liferay.site.navigation.menu.web.internal.configuration.SiteNavigationMenuWebTemplateConfiguration",
	localization = "content/Language",
	name = "site-navigation-menu-web-template-configuration-name"
)
public interface SiteNavigationMenuWebTemplateConfiguration {

	@Meta.AD(
		deflt = "navbar-blank-ftl", name = "ddm-template-key-default",
		required = false
	)
	public String ddmTemplateKeyDefault();

}