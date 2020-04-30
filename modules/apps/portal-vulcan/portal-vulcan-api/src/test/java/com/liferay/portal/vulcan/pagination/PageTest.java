/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.pagination;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

/**
 * @author Alejandro Hernández
 */
public class PageTest {

	@Test
	public void testOf() {

		// Empty list

		Page<Integer> page = Page.of(Collections.emptyList());

		assertThat(page.getItems(), is(empty()));
		assertThat(page.getLastPage(), is(1L));
		assertThat(page.getPage(), is(1L));
		assertThat(page.getPageSize(), is(0L));
		assertThat(page.getTotalCount(), is(0L));
		assertThat(page.hasNext(), is(false));
		assertThat(page.hasPrevious(), is(false));

		// List without pagination

		page = Page.of(Arrays.asList(1, 2, 3));

		assertThat(page.getItems(), contains(1, 2, 3));
		assertThat(page.getLastPage(), is(1L));
		assertThat(page.getPage(), is(1L));
		assertThat(page.getPageSize(), is(3L));
		assertThat(page.getTotalCount(), is(3L));
		assertThat(page.hasNext(), is(false));
		assertThat(page.hasPrevious(), is(false));

		// List with pagination

		page = Page.of(Arrays.asList(1, 2, 3), Pagination.of(3, 3), 25);

		assertThat(page.getItems(), contains(1, 2, 3));
		assertThat(page.getLastPage(), is(9L));
		assertThat(page.getPage(), is(3L));
		assertThat(page.getPageSize(), is(3L));
		assertThat(page.getTotalCount(), is(25L));
		assertThat(page.hasNext(), is(true));
		assertThat(page.hasPrevious(), is(true));
	}

}