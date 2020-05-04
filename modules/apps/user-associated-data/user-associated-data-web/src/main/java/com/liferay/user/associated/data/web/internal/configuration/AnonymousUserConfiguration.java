/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Drew Brokke
 */
@ExtendedObjectClassDefinition(
	category = "users", factoryInstanceLabelAttribute = "companyId",
	scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
	factory = true,
	id = "com.liferay.user.associated.data.web.internal.configuration.AnonymousUserConfiguration",
	localization = "content/Language",
	name = "anonymous-user-configuration-name"
)
public interface AnonymousUserConfiguration {

	@Meta.AD(
		deflt = "0", description = "company-id-description",
		name = "company-id", required = false
	)
	public long companyId();

	@Meta.AD(
		deflt = "0", description = "user-id-description", name = "user-id",
		required = false
	)
	public long userId();

}