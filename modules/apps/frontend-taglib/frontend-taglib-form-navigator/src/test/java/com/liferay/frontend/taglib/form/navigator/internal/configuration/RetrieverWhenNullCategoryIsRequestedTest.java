/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.form.navigator.internal.configuration;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alejandro Tardín
 */
public class RetrieverWhenNullCategoryIsRequestedTest
	extends BaseFormNavigatorEntryConfigurationRetrieverTestCase {

	@Override
	public void setUp() throws Exception {
		super.setUp();

		StringBundler sb = new StringBundler(3);

		sb.append("add");
		sb.append(StringPool.EQUAL);
		sb.append("formNavigatorEntryKey1,formNavigatorEntryKey2");

		createConfiguration("form1", new String[] {sb.toString()});
	}

	@Test
	public void testReturnsTheKeysInThatLineWhenAskedForANullCategory() {
		List<String> formNavigatorEntryKeys =
			formNavigatorEntryConfigurationRetriever.getFormNavigatorEntryKeys(
				"form1", null, "add"
			).get();

		Assert.assertEquals(
			formNavigatorEntryKeys.toString(), 2,
			formNavigatorEntryKeys.size());

		Iterator<String> iterator = formNavigatorEntryKeys.iterator();

		Assert.assertEquals("formNavigatorEntryKey1", iterator.next());
		Assert.assertEquals("formNavigatorEntryKey2", iterator.next());
	}

}