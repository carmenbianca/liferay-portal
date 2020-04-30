/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.suggest;

import com.liferay.portal.kernel.search.SearchException;

import org.apache.solr.client.solrj.SolrQuery;

/**
 * @author Michael C. Han
 */
public interface NGramQueryBuilder {

	public SolrQuery getNGramQuery(String input) throws SearchException;

}