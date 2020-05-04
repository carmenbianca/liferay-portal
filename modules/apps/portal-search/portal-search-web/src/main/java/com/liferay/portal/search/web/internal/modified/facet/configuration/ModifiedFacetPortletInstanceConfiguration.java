/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.modified.facet.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Kevin Tan
 */
@ExtendedObjectClassDefinition(
	category = "search",
	scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
	id = "com.liferay.portal.search.web.internal.modified.facet.configuration.ModifiedFacetPortletInstanceConfiguration",
	localization = "content/Language",
	name = "modified-facet-portlet-instance-configuration-name"
)
public interface ModifiedFacetPortletInstanceConfiguration {

	@Meta.AD(deflt = "0", name = "display-style-group-id", required = false)
	public long displayStyleGroupId();

	@Meta.AD(name = "display-style", required = false)
	public String displayStyle();

}