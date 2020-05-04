/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.custom.filter.portlet.action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André de Oliveira
 */
public class QueryTypeEntriesHolder {

	public QueryTypeEntriesHolder() {
		add("bool", "Bool");
		add("exists", "Exists");
		add("fuzzy", "Fuzzy");
		add("match", "Match");
		add("match_phrase", "Match Phrase");
		add("match_phrase_prefix", "Match Phrase Prefix");
		add("multi_match", "Multi Match");
		add("prefix", "Prefix");
		add("query_string", "Query String");
		add("regexp", "Regexp");
		add("script", "Script");
		add("simple_query_string", "Simple Query String");
		add("term", "Term");
		add("wildcard", "Wildcard");
	}

	public List<QueryTypeEntry> getQueryTypeEntries() {
		return _queryTypeEntries;
	}

	protected void add(String typeId, String name) {
		_queryTypeEntries.add(
			new QueryTypeEntry() {
				{
					setName(name);
					setTypeId(typeId);
				}
			});
	}

	private final List<QueryTypeEntry> _queryTypeEntries = new ArrayList<>();

}