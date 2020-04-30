/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ExtendedObjectClassDefinition(category = "search")
@Meta.OCD(
	id = "com.liferay.portal.search.configuration.QueryPreProcessConfiguration",
	localization = "content/Language",
	name = "query-pre-process-configuration-name"
)
@ProviderType
public interface QueryPreProcessConfiguration {

	@Meta.AD(
		deflt = "emailAddress|license|path|properties|screenName|tag|treePath|userName",
		name = "field-name-patterns", required = false
	)
	public String[] fieldNamePatterns();

}