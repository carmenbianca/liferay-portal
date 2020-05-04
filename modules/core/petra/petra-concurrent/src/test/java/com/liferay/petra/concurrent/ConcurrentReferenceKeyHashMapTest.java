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
public class ConcurrentReferenceKeyHashMapTest
	extends BaseConcurrentReferenceHashMapTestCase {

	@ClassRule
	@Rule
	public static final CodeCoverageAssertor codeCoverageAssertor =
		CodeCoverageAssertor.INSTANCE;

	@Test
	public void testAutoRemove() throws InterruptedException {
		testAutoRemove(
			new ConcurrentReferenceKeyHashMap<String, Object>(
				FinalizeManager.SOFT_REFERENCE_FACTORY),
			true);
		testAutoRemove(
			new ConcurrentReferenceKeyHashMap<String, Object>(
				FinalizeManager.WEAK_REFERENCE_FACTORY),
			false);
	}

	@Test
	public void testConstructor() {
		ConcurrentMap<Reference<String>, Object> innerConcurrentMap =
			new ConcurrentHashMap<>();

		ConcurrentReferenceKeyHashMap<String, Object>
			concurrentReferenceKeyHashMap = new ConcurrentReferenceKeyHashMap<>(
				innerConcurrentMap, FinalizeManager.WEAK_REFERENCE_FACTORY);

		Assert.assertSame(
			innerConcurrentMap,
			concurrentReferenceKeyHashMap.innerConcurrentMap);

		new ConcurrentReferenceKeyHashMap<String, Object>(
			10, FinalizeManager.WEAK_REFERENCE_FACTORY);
		new ConcurrentReferenceKeyHashMap<String, Object>(
			10, 0.75F, 4, FinalizeManager.WEAK_REFERENCE_FACTORY);
	}

	@Test
	public void testPutAll() {
		ConcurrentReferenceKeyHashMap<String, Object>
			concurrentReferenceKeyHashMap = new ConcurrentReferenceKeyHashMap<>(
				FinalizeManager.WEAK_REFERENCE_FACTORY);

		Map<String, Object> dataMap = createDataMap();

		concurrentReferenceKeyHashMap.putAll(dataMap);

		Assert.assertEquals(dataMap, concurrentReferenceKeyHashMap);
	}

}