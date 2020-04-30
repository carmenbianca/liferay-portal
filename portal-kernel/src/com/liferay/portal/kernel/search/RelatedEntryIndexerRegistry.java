/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface RelatedEntryIndexerRegistry {

	public List<RelatedEntryIndexer> getRelatedEntryIndexers();

	public List<RelatedEntryIndexer> getRelatedEntryIndexers(Class clazz);

	public List<RelatedEntryIndexer> getRelatedEntryIndexers(String className);

}