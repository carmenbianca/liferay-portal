/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.form.navigator.internal.configuration;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alejandro Tardín
 */
public class RetrieverWhenThereAreSeveralConfigurationsTest
	extends BaseFormNavigatorEntryConfigurationRetrieverTestCase {

	@Override
	public void setUp() throws Exception {
		super.setUp();

		StringBundler sb1 = new StringBundler(4);

		sb1.append("add.general");
		sb1.append(StringPool.EQUAL);
		sb1.append("formNavigatorEntryKey1,formNavigatorEntryKey2,");
		sb1.append("formNavigatorEntryKey3");

		StringBundler sb2 = new StringBundler(4);

		sb2.append("update.general");
		sb2.append(StringPool.EQUAL);
		sb2.append("formNavigatorEntryKey1,formNavigatorEntryKey4,");
		sb2.append("formNavigatorEntryKey5");

		createConfiguration("form1", new String[] {sb1.toString()});
		createConfiguration("form1", new String[] {sb2.toString()});
	}

	@Test
	public void testContainsValuesForEntry1() {
		List<String> formNavigatorEntryKeys =
			formNavigatorEntryConfigurationRetriever.getFormNavigatorEntryKeys(
				"form1", "general", "add"
			).get();

		Assert.assertEquals(
			formNavigatorEntryKeys.toString(), 3,
			formNavigatorEntryKeys.size());

		Iterator<String> iterator = formNavigatorEntryKeys.iterator();

		Assert.assertEquals("formNavigatorEntryKey1", iterator.next());
		Assert.assertEquals("formNavigatorEntryKey2", iterator.next());
		Assert.assertEquals("formNavigatorEntryKey3", iterator.next());
	}

	@Test
	public void testContainsValuesForEntry2() {
		List<String> formNavigatorEntryKeys =
			formNavigatorEntryConfigurationRetriever.getFormNavigatorEntryKeys(
				"form1", "general", "update"
			).get();

		Assert.assertEquals(
			formNavigatorEntryKeys.toString(), 3,
			formNavigatorEntryKeys.size());

		Iterator<String> iterator = formNavigatorEntryKeys.iterator();

		Assert.assertEquals("formNavigatorEntryKey1", iterator.next());
		Assert.assertEquals("formNavigatorEntryKey4", iterator.next());
		Assert.assertEquals("formNavigatorEntryKey5", iterator.next());
	}

	@Test
	public void testReturnsEmptyOptionalForAnUnknownCategory() {
		Optional<List<String>> formNavigatorEntryKeys =
			formNavigatorEntryConfigurationRetriever.getFormNavigatorEntryKeys(
				"form1", "unknownCategory", "add");

		Assert.assertFalse(formNavigatorEntryKeys.isPresent());
	}

	@Test
	public void testReturnsEmptyOptionalForAnUnknownContext() {
		Optional<List<String>> formNavigatorEntryKeys =
			formNavigatorEntryConfigurationRetriever.getFormNavigatorEntryKeys(
				"form1", "general", "unknownContext");

		Assert.assertFalse(formNavigatorEntryKeys.isPresent());
	}

	@Test
	public void testReturnsEmptyOptionalForAnUnknownFormId() {
		Optional<List<String>> formNavigatorEntryKeys =
			formNavigatorEntryConfigurationRetriever.getFormNavigatorEntryKeys(
				"unknownForm", "general", "add");

		Assert.assertFalse(formNavigatorEntryKeys.isPresent());
	}

}