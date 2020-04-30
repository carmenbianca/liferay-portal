/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.cmis.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Adolfo Pérez
 */
@ExtendedObjectClassDefinition(category = "file-storage")
@Meta.OCD(
	id = "com.liferay.document.library.repository.cmis.configuration.CMISRepositoryConfiguration",
	localization = "content/Language",
	name = "cmis-repository-configuration-name"
)
public interface CMISRepositoryConfiguration {

	@Meta.AD(
		deflt = "1", description = "delete-depth-description",
		name = "delete-depth-name", required = false
	)
	public int deleteDepth();

}