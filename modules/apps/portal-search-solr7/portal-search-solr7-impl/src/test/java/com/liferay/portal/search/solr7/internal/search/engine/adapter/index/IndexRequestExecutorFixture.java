/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.IndexRequestExecutor;
import com.liferay.portal.search.solr7.internal.connection.SolrClientManager;

/**
 * @author Bryan Engler
 */
public class IndexRequestExecutorFixture {

	public IndexRequestExecutor getIndexRequestExecutor() {
		return _indexRequestExecutor;
	}

	public void setUp() {
		_indexRequestExecutor = createIndexRequestExecutor(_solrClientManager);
	}

	protected IndexRequestExecutor createIndexRequestExecutor(
		SolrClientManager solrClientManager) {

		return new SolrIndexRequestExecutor() {
			{
				setRefreshIndexRequestExecutor(
					createRefreshIndexRequestExecutor(solrClientManager));
			}
		};
	}

	protected RefreshIndexRequestExecutor createRefreshIndexRequestExecutor(
		SolrClientManager solrClientManager) {

		return new RefreshIndexRequestExecutorImpl() {
			{
				setSolrClientManager(solrClientManager);
			}
		};
	}

	protected void setSolrClientManager(SolrClientManager solrClientManager) {
		_solrClientManager = solrClientManager;
	}

	private IndexRequestExecutor _indexRequestExecutor;
	private SolrClientManager _solrClientManager;

}