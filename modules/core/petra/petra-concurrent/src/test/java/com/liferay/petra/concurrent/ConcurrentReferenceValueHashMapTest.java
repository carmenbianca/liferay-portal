/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.concurrent;

import com.liferay.petra.memory.FinalizeManager;
import com.liferay.portal.kernel.test.rule.CodeCoverageAssertor;

import java.lang.ref.Reference;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Shuyang Zhou
 */
public class ConcurrentReferenceValueHashMapTest
	extends BaseConcurrentReferenceHashMapTestCase {

	@ClassRule
	@Rule
	public static final CodeCoverageAssertor codeCoverageAssertor =
		CodeCoverageAssertor.INSTANCE;

	@Test
	public void testAutoRemove() throws InterruptedException {
		testAutoRemove(
			new ConcurrentReferenceValueHashMap<String, Object>(
				FinalizeManager.SOFT_REFERENCE_FACTORY),
			true);
		testAutoRemove(
			new ConcurrentReferenceValueHashMap<String, Object>(
				FinalizeManager.WEAK_REFERENCE_FACTORY),
			false);
	}

	@Test
	public void testConstructor() {
		ConcurrentMap<String, Reference<Object>> innerConcurrentMap =
			new ConcurrentHashMap<>();

		ConcurrentReferenceValueHashMap<String, Object>
			concurrentReferenceValueHashMap =
				new ConcurrentReferenceValueHashMap<>(
					innerConcurrentMap, FinalizeManager.WEAK_REFERENCE_FACTORY);

		Assert.assertSame(
			innerConcurrentMap,
			concurrentReferenceValueHashMap.innerConcurrentMap);

		new ConcurrentReferenceValueHashMap<String, Object>(
			10, FinalizeManager.WEAK_REFERENCE_FACTORY);
		new ConcurrentReferenceValueHashMap<String, Object>(
			10, 0.75F, 4, FinalizeManager.WEAK_REFERENCE_FACTORY);
	}

	@Test
	public void testPutAll() {
		ConcurrentReferenceValueHashMap<String, Object>
			concurrentReferenceValueHashMap =
				new ConcurrentReferenceValueHashMap<>(
					FinalizeManager.WEAK_REFERENCE_FACTORY);

		Map<String, Object> dataMap = createDataMap();

		concurrentReferenceValueHashMap.putAll(dataMap);

		Assert.assertEquals(dataMap, concurrentReferenceValueHashMap);
	}

}