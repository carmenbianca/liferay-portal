/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.facet;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.search.facet.collector.FacetCollector;
import com.liferay.portal.kernel.search.facet.collector.TermCollector;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bryan Engler
 * @author André de Oliveira
 */
public class SimpleFacetCollector implements FacetCollector {

	public SimpleFacetCollector(
		String fieldName, List<TermCollector> termCollectors) {

		_fieldName = fieldName;

		for (TermCollector termCollector : termCollectors) {
			_termCollectors.put(termCollector.getTerm(), termCollector);
		}
	}

	@Override
	public String getFieldName() {
		return _fieldName;
	}

	@Override
	public TermCollector getTermCollector(String term) {
		return _termCollectors.get(term);
	}

	@Override
	public List<TermCollector> getTermCollectors() {
		return ListUtil.sort(
			ListUtil.fromMapValues(_termCollectors),
			Comparator.comparing(
				TermCollector::getFrequency, Comparator.reverseOrder()));
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{fieldName=");
		sb.append(_fieldName);
		sb.append(", termCollectors=");
		sb.append(_termCollectors);
		sb.append("}");

		return sb.toString();
	}

	private final String _fieldName;
	private final Map<String, TermCollector> _termCollectors = new HashMap<>();

}