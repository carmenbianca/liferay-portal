/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.RefreshIndexRequest;
import com.liferay.portal.search.engine.adapter.index.RefreshIndexResponse;
import com.liferay.portal.search.solr7.internal.connection.SolrClientManager;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = RefreshIndexRequestExecutor.class)
public class RefreshIndexRequestExecutorImpl
	implements RefreshIndexRequestExecutor {

	@Override
	public RefreshIndexResponse execute(
		RefreshIndexRequest refreshIndexRequest) {

		String[] indexNames = refreshIndexRequest.getIndexNames();

		SolrClient solrClient = _solrClientManager.getSolrClient();

		try {
			solrClient.commit(indexNames[0]);

			return new RefreshIndexResponse();
		}
		catch (Exception exception) {
			if (exception instanceof SolrException) {
				SolrException solrException = (SolrException)exception;

				throw solrException;
			}

			throw new RuntimeException(exception);
		}
	}

	@Reference(unbind = "-")
	protected void setSolrClientManager(SolrClientManager solrClientManager) {
		_solrClientManager = solrClientManager;
	}

	private SolrClientManager _solrClientManager;

}