/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Shuyang Zhou
 */
public class SetUtilTest {

	@Test
	public void testConstructor() {
		new SetUtil();
	}

	@Test
	public void testIntersectEmptyShortcut() {
		Assert.assertSame(
			Collections.emptySet(),
			SetUtil.intersect(new ArrayList<String>(), Arrays.asList("a")));
		Assert.assertSame(
			Collections.emptySet(),
			SetUtil.intersect(Arrays.asList("a"), new ArrayList<String>()));
	}

	@Test
	public void testIntersectWithoutWrapping() {
		Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
		Set<String> set2 = new HashSet<>(Arrays.asList("c", "d"));

		Assert.assertSame(set2, SetUtil.intersect(set1, set2));
		Assert.assertEquals(set2, new HashSet<String>(Arrays.asList("c")));

		Set<String> set3 = new HashSet<>(Arrays.asList("c", "d", "e"));

		Assert.assertSame(set1, SetUtil.intersect(set1, set3));

		Assert.assertEquals(set1, new HashSet<String>(Arrays.asList("c")));
	}

	@Test
	public void testIntersectWithWrapping() {
		List<String> list1 = Arrays.asList("a", "b", "c");
		List<String> list2 = Arrays.asList("c", "d");

		Set<String> set = SetUtil.intersect(list1, list2);

		Assert.assertEquals(set, new HashSet<String>(Arrays.asList("c")));

		List<String> list3 = Arrays.asList("c", "d", "e");

		set = SetUtil.intersect(list1, list3);

		Assert.assertEquals(set, new HashSet<String>(Arrays.asList("c")));
	}

}