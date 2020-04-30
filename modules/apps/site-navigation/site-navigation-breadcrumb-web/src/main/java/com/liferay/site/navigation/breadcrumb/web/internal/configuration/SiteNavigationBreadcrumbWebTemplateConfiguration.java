/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.breadcrumb.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Juergen Kappler
 */
@ExtendedObjectClassDefinition(category = "breadcrumbs")
@Meta.OCD(
	id = "com.liferay.site.navigation.breadcrumb.web.internal.configuration.SiteNavigationBreadcrumbWebTemplateConfiguration",
	localization = "content/Language",
	name = "site-navigation-breadcrumb-web-template-configuration-name"
)
public interface SiteNavigationBreadcrumbWebTemplateConfiguration {

	@Meta.AD(
		deflt = "breadcrumb-horizontal-ftl", name = "ddm-template-key-default",
		required = false
	)
	public String ddmTemplateKeyDefault();

}