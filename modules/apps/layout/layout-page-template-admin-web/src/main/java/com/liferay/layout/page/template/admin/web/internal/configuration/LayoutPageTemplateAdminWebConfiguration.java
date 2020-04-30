/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.admin.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Eudaldo Alonso
 */
@ExtendedObjectClassDefinition(category = "pages")
@Meta.OCD(
	id = "com.liferay.layout.page.template.admin.web.internal.configuration.LayoutPageTemplateAdminWebConfiguration",
	localization = "content/Language",
	name = "layout-page-template-admin-web-configuration-name"
)
public interface LayoutPageTemplateAdminWebConfiguration {

	@Meta.AD(
		deflt = ".gif,.jpeg,.jpg,.png",
		name = "allowed-thumbnail-file-extensions", required = false
	)
	public String[] thumbnailExtensions();

}