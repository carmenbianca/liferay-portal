/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.groupby;

import com.liferay.portal.search.groupby.GroupByRequest;

import java.util.Locale;

import org.apache.solr.client.solrj.SolrQuery;

/**
 * @author Miguel Angelo Caldas Gallindo
 */
public interface GroupByTranslator {

	public void translate(
		SolrQuery solrQuery, GroupByRequest groupByRequest, Locale locale,
		String[] highlightFieldNames, boolean highlightEnabled,
		boolean highlightRequireFieldMatch, int highlightFragmentSize,
		int highlightSnippetSize);

}