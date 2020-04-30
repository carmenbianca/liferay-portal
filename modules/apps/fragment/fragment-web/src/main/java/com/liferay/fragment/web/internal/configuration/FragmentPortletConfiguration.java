/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Eudaldo Alonso
 */
@ExtendedObjectClassDefinition(
	category = "page-fragments",
	scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
@Meta.OCD(
	id = "com.liferay.fragment.web.internal.configuration.FragmentPortletConfiguration",
	localization = "content/Language",
	name = "fragment-thumbnail-configuration-name"
)
public interface FragmentPortletConfiguration {

	@Meta.AD(
		deflt = ".gif,.jpeg,.jpg,.png",
		name = "allowed-thumbnail-file-extensions", required = false
	)
	public String[] thumbnailExtensions();

}