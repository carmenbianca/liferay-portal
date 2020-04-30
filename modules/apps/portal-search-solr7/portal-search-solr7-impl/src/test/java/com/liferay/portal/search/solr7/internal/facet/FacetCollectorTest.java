/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.facet;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.facet.collector.TermCollector;
import com.liferay.portal.search.facet.Facet;
import com.liferay.portal.search.internal.facet.FacetImpl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.solr.common.util.NamedList;

import org.junit.Test;

/**
 * @author Bryan Engler
 */
public class FacetCollectorTest {

	@Test
	public void testSolrFacetFieldCollectorCountType() {
		NamedList namedList1 = new NamedList();

		namedList1.add("count", Long.valueOf(3));
		namedList1.add("val", "alpha");

		NamedList namedList2 = new NamedList();

		namedList2.add("count", Integer.valueOf(7));
		namedList2.add("val", "bravo");

		List<NamedList> bucketNamedList = new ArrayList<>();

		bucketNamedList.add(namedList1);
		bucketNamedList.add(namedList2);

		NamedList fieldNamedList = new NamedList();

		fieldNamedList.add("buckets", bucketNamedList);

		NamedList namedList = new NamedList();

		namedList.add("field", fieldNamedList);

		Facet facet = new FacetImpl("field", new SearchContext());

		SolrFacetFieldCollector solrFacetFieldCollector =
			new SolrFacetFieldCollector(facet, namedList);

		TermCollector termCollector = solrFacetFieldCollector.getTermCollector(
			"alpha");

		Assert.assertEquals(3, termCollector.getFrequency());

		termCollector = solrFacetFieldCollector.getTermCollector("bravo");

		Assert.assertEquals(7, termCollector.getFrequency());
	}

	@Test
	public void testSolrFacetQueryCollector() {
		NamedList namedList1 = new NamedList();

		String bucket1 = "field_alpha";

		NamedList namedList2 = new NamedList();

		namedList2.add("count", Long.valueOf(3));

		namedList1.add(bucket1, namedList2);

		String bucket2 = "field_bravo";

		NamedList namedList3 = new NamedList();

		namedList3.add("count", Integer.valueOf(7));

		namedList1.add(bucket2, namedList3);

		Facet facet = new FacetImpl("field", new SearchContext());

		SolrFacetQueryCollector solrFacetFieldCollector =
			new SolrFacetQueryCollector(facet, namedList1);

		TermCollector termCollector = solrFacetFieldCollector.getTermCollector(
			"alpha");

		Assert.assertEquals(3, termCollector.getFrequency());

		termCollector = solrFacetFieldCollector.getTermCollector("bravo");

		Assert.assertEquals(7, termCollector.getFrequency());
	}

}