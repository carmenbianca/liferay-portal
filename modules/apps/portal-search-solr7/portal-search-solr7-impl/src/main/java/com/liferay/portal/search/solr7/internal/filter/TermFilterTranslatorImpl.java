/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.filter;

import com.liferay.portal.kernel.search.filter.TermFilter;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.solr.client.solrj.util.ClientUtils;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = TermFilterTranslator.class)
public class TermFilterTranslatorImpl implements TermFilterTranslator {

	@Override
	public Query translate(TermFilter termFilter) {
		Term term = new Term(
			termFilter.getField(),
			ClientUtils.escapeQueryChars(termFilter.getValue()));

		return new TermQuery(term);
	}

}