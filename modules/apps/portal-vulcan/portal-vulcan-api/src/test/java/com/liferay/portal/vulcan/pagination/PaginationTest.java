/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.pagination;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * @author Alejandro Hernández
 */
public class PaginationTest {

	@Test
	public void testOf() {
		Pagination pagination = Pagination.of(3, 30);

		assertThat(pagination.getEndPosition(), is(90));
		assertThat(pagination.getPage(), is(3));
		assertThat(pagination.getPageSize(), is(30));
		assertThat(pagination.getStartPosition(), is(60));
	}

}