/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.facet;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.search.facet.collector.DefaultTermCollector;
import com.liferay.portal.kernel.search.facet.collector.FacetCollector;
import com.liferay.portal.kernel.search.facet.collector.TermCollector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Bryan Engler
 * @author André de Oliveira
 */
public class FacetDiscounter {

	public FacetDiscounter(Facet facet) {
		_facet = facet;
	}

	public void discount(Collection<Document> documents) {
		for (Document document : documents) {
			_exclude(document);
		}

		_decrement();
	}

	private void _decrement() {
		if (_excludedTermsMap.isEmpty()) {
			return;
		}

		FacetCollector facetCollector = _facet.getFacetCollector();

		List<TermCollector> termCollectors = facetCollector.getTermCollectors();

		List<TermCollector> newTermCollectors = new ArrayList<>(
			termCollectors.size());

		for (TermCollector termCollector : termCollectors) {
			String term = termCollector.getTerm();

			int exclusions = _getExclusions(term);

			int frequency = termCollector.getFrequency() - exclusions;

			if (frequency > 0) {
				newTermCollectors.add(
					new DefaultTermCollector(term, frequency));
			}
		}

		_facet.setFacetCollector(
			new SimpleFacetCollector(
				facetCollector.getFieldName(), newTermCollectors));
	}

	private void _exclude(Document document) {
		Field field = document.getField(_facet.getFieldName());

		if (field == null) {
			return;
		}

		Stream<String> termsStream = _findTermsOfField(field);

		termsStream.forEach(this::_exclude);
	}

	private void _exclude(String term) {
		int exclusions = _getExclusions(term);

		_excludedTermsMap.put(term, exclusions + 1);
	}

	private Stream<String> _findTermsOfField(Field field) {
		FacetCollector facetCollector = _facet.getFacetCollector();

		List<TermCollector> termCollectors = facetCollector.getTermCollectors();

		Stream<TermCollector> termCollectorsStream = termCollectors.stream();

		Stream<String> termsStream = termCollectorsStream.map(
			TermCollector::getTerm);

		return termsStream.filter(
			term -> FacetBucketUtil.isFieldInBucket(field, term, _facet));
	}

	private int _getExclusions(String term) {
		Integer exclusions = _excludedTermsMap.get(term);

		if (exclusions != null) {
			return exclusions;
		}

		return 0;
	}

	private final Map<String, Integer> _excludedTermsMap = new HashMap<>();
	private final Facet _facet;

}