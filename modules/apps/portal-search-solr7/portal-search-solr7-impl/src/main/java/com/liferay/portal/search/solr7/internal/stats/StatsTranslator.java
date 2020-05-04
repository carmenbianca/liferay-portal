/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.stats;

import com.liferay.portal.search.stats.StatsRequest;
import com.liferay.portal.search.stats.StatsResponse;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.FieldStatsInfo;

/**
 * @author Miguel Angelo Caldas Gallindo
 */
public interface StatsTranslator {

	public void populateRequest(SolrQuery solrQuery, StatsRequest statsRequest);

	public StatsResponse translateResponse(FieldStatsInfo fieldStatsInfo);

}