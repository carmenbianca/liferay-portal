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
public class RetrieverWhenAConfigurationEntryHasDuplicatesTest
	extends BaseFormNavigatorEntryConfigurationRetrieverTestCase {

	@Override
	public void setUp() throws Exception {
		super.setUp();

		StringBundler sb = new StringBundler(6);

		sb.append("add.general");
		sb.append(StringPool.EQUAL);
		sb.append("formNavigatorEntryKey4,formNavigatorEntryKey3,");
		sb.append("formNavigatorEntryKey2,formNavigatorEntryKey1,");
		sb.append("formNavigatorEntryKey1,formNavigatorEntryKey2,");
		sb.append("formNavigatorEntryKey3,formNavigatorEntryKey4");

		createConfiguration("form1", new String[] {sb.toString()});
	}

	@Test
	public void testOnlyTheFirstOcurrenceIsRetrieved() {
		List<String> formNavigatorEntryKeys =
			formNavigatorEntryConfigurationRetriever.getFormNavigatorEntryKeys(
				"form1", "general", "add"
			).get();

		Assert.assertEquals(
			formNavigatorEntryKeys.toString(), 4,
			formNavigatorEntryKeys.size());

		Iterator<String> iterator = formNavigatorEntryKeys.iterator();

		Assert.assertEquals("formNavigatorEntryKey4", iterator.next());
		Assert.assertEquals("formNavigatorEntryKey3", iterator.next());
		Assert.assertEquals("formNavigatorEntryKey2", iterator.next());
		Assert.assertEquals("formNavigatorEntryKey1", iterator.next());
	}

}