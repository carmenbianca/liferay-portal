/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.document;

import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.search.test.util.indexing.DocumentFixture;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author André de Oliveira
 */
public class DocumentImplTest {

	@Before
	public void setUp() throws Exception {
		documentFixture.setUp();

		documentImpl = new DocumentImpl();
	}

	@After
	public void tearDown() throws Exception {
		documentFixture.tearDown();
	}

	@Test
	public void testAddDate() throws Exception {
		clearDateFormat();

		documentImpl.addDate(RandomTestUtil.randomString(), new Date());
	}

	@Test
	public void testAddDateSortable() throws Exception {
		clearDateFormat();

		documentImpl.addDateSortable(RandomTestUtil.randomString(), new Date());
	}

	protected void clearDateFormat() {
		ReflectionTestUtil.setFieldValue(
			DocumentImpl.class, "_dateFormat", null);
	}

	protected DocumentFixture documentFixture = new DocumentFixture();
	protected DocumentImpl documentImpl;

}