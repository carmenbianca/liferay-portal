/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Bryan Engler
 */
@ExtendedObjectClassDefinition(category = "search")
@Meta.OCD(
	id = "com.liferay.portal.search.configuration.ReindexConfiguration",
	localization = "content/Language", name = "reindex-configuration-name"
)
@ProviderType
public interface ReindexConfiguration {

	@Meta.AD(
		deflt = "com.liferay.journal.model.JournalArticle=10000",
		description = "indexing-batch-sizes-help",
		name = "indexing-batch-sizes", required = false
	)
	public String[] indexingBatchSizes();

}