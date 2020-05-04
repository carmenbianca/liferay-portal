/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.test.util;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.search.facet.collector.FacetCollector;
import com.liferay.portal.kernel.search.facet.collector.TermCollector;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

/**
 * @author André de Oliveira
 */
public class FacetsAssert {

	public static void assertFrequencies(
		String message, Facet facet, String expected) {

		FacetCollector facetCollector = facet.getFacetCollector();

		List<TermCollector> termCollectors = facetCollector.getTermCollectors();

		Assert.assertNotNull(termCollectors);

		Stream<TermCollector> stream = termCollectors.stream();

		Assert.assertEquals(
			message, expected,
			stream.map(
				FacetsAssert::toString
			).collect(
				Collectors.toList()
			).toString());
	}

	public static void assertFrequencies(
		String facetName, SearchContext searchContext, Hits hits,
		Map<String, Integer> expected) {

		Map<String, Facet> facets = searchContext.getFacets();

		Facet facet = facets.get(facetName);

		FacetCollector facetCollector = facet.getFacetCollector();

		AssertUtils.assertEquals(
			StringBundler.concat(
				searchContext.getAttribute("queryString"), "->",
				StringUtil.merge(hits.getDocs())),
			expected,
			TermCollectorUtil.toMap(facetCollector.getTermCollectors()));
	}

	public static void assertFrequencies(
		String facetName, SearchContext searchContext, List<String> expected) {

		assertFrequencies(
			(String)searchContext.getAttribute("queryString"),
			searchContext.getFacet(facetName), String.valueOf(expected));
	}

	protected static String toString(TermCollector termCollector) {
		return termCollector.getTerm() + "=" + termCollector.getFrequency();
	}

}