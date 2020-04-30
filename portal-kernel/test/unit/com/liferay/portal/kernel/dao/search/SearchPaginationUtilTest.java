/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Roberto Díaz
 */
public class SearchPaginationUtilTest {

	@Test
	public void testCalculateStartAndEndWhenEmptyResultsPage() {
		int[] startAndEnd = SearchPaginationUtil.calculateStartAndEnd(
			40, 60, 10);

		Assert.assertEquals(0, startAndEnd[0]);
		Assert.assertEquals(10, startAndEnd[1]);
	}

	@Test
	public void testCalculateStartAndEndWhenFullResultsPage() {
		int[] startAndEnd = SearchPaginationUtil.calculateStartAndEnd(
			20, 40, 20);

		Assert.assertEquals(0, startAndEnd[0]);
		Assert.assertEquals(20, startAndEnd[1]);
	}

	@Test
	public void testCalculateStartAndEndWhenNoResults() {
		int[] startAndEnd = SearchPaginationUtil.calculateStartAndEnd(
			20, 40, 0);

		Assert.assertEquals(0, startAndEnd[0]);
		Assert.assertEquals(0, startAndEnd[1]);
	}

	@Test
	public void testCalculateStartAndEndWhenResultsPage() {
		int[] startAndEnd = SearchPaginationUtil.calculateStartAndEnd(
			20, 40, 80);

		Assert.assertEquals(20, startAndEnd[0]);
		Assert.assertEquals(40, startAndEnd[1]);
	}

	@Test
	public void testNotCalculateStartAndEndWhenNoResultsAndInitialPage() {
		int[] startAndEnd = SearchPaginationUtil.calculateStartAndEnd(0, 20, 0);

		Assert.assertEquals(0, startAndEnd[0]);
		Assert.assertEquals(0, startAndEnd[1]);
	}

}