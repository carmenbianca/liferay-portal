/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.test.util.indexing;

import com.liferay.portal.kernel.search.IndexSearcher;
import com.liferay.portal.kernel.search.IndexWriter;
import com.liferay.portal.search.engine.adapter.SearchEngineAdapter;

/**
 * @author Miguel Angelo Caldas Gallindo
 * @author André de Oliveira
 */
public interface IndexingFixture {

	public long getCompanyId();

	public IndexSearcher getIndexSearcher();

	public IndexWriter getIndexWriter();

	public SearchEngineAdapter getSearchEngineAdapter();

	public boolean isSearchEngineAvailable();

	public void setUp() throws Exception;

	public void tearDown() throws Exception;

}