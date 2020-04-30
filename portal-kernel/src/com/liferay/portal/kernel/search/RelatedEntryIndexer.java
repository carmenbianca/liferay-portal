/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.search.filter.BooleanFilter;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface RelatedEntryIndexer {

	public void addRelatedClassNames(
			BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws Exception;

	public void addRelatedEntryFields(Document document, Object obj)
		throws Exception;

	public boolean isVisibleRelatedEntry(long classPK, int status)
		throws Exception;

	public void updateFullQuery(SearchContext searchContext);

}