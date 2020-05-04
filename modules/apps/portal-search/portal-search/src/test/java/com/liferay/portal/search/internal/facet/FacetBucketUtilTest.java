/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.facet;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.search.facet.MultiValueFacet;
import com.liferay.portal.kernel.search.facet.RangeFacet;
import com.liferay.portal.kernel.search.facet.SimpleFacet;
import com.liferay.portal.kernel.test.util.RandomTestUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author André de Oliveira
 */
public class FacetBucketUtilTest {

	@Test
	public void testFacetImpl() {
		Field field = new Field(_FIELD_NAME, new String[] {"foo", "bar"});

		Facet facet = new FacetImpl(_FIELD_NAME, null);

		Assert.assertTrue(FacetBucketUtil.isFieldInBucket(field, "foo", facet));
		Assert.assertTrue(FacetBucketUtil.isFieldInBucket(field, "bar", facet));
	}

	@Test
	public void testMultiValueFacet() {
		Field field = new Field(_FIELD_NAME, new String[] {"foo", "bar"});

		Facet facet = new MultiValueFacet(null);

		Assert.assertTrue(FacetBucketUtil.isFieldInBucket(field, "bar", facet));
	}

	@Test
	public void testRangeFacet() {
		Field field = new Field(_FIELD_NAME, "007");

		Facet facet = new RangeFacet(null);

		Assert.assertTrue(
			FacetBucketUtil.isFieldInBucket(field, "[001 TO 999]", facet));
	}

	@Test
	public void testSimpleFacet() {
		Field field = new Field(_FIELD_NAME, "foo");

		Facet facet = new SimpleFacet(null);

		Assert.assertTrue(FacetBucketUtil.isFieldInBucket(field, "foo", facet));
	}

	private static final String _FIELD_NAME = RandomTestUtil.randomString();

}