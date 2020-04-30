/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Leonardo Barros
 */
@ExtendedObjectClassDefinition(
	category = "data-providers",
	scope = ExtendedObjectClassDefinition.Scope.GROUP
)
@Meta.OCD(
	id = "com.liferay.dynamic.data.mapping.data.provider.configuration.DDMDataProviderConfiguration",
	localization = "content/Language",
	name = "ddm-data-provider-configuration-name"
)
public interface DDMDataProviderConfiguration {

	@Meta.AD(
		deflt = "false", description = "access-local-network-description",
		name = "access-local-network-name", required = false
	)
	public boolean accessLocalNetwork();

}