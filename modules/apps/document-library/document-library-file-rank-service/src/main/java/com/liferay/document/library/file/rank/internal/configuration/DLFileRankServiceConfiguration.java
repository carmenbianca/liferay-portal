/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.file.rank.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Sergio González
 */
@ExtendedObjectClassDefinition(category = "documents-and-media")
@Meta.OCD(
	id = "com.liferay.document.library.file.rank.internal.configuration.DLFileRankServiceConfiguration",
	localization = "content/Language",
	name = "dl-file-rank-service-configuration-name"
)
public interface DLFileRankServiceConfiguration {

	@Meta.AD(deflt = "5", name = "max-size", required = false)
	public int maxSize();

}