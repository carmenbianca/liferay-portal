/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.form.navigator.internal.configuration;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alejandro Tardín
 */
public class RetrieverWhenThereIsNoConfigAtAllTest
	extends BaseFormNavigatorEntryConfigurationRetrieverTestCase {

	@Test
	public void testReturnsEmptyOptional() {
		Optional<List<String>> formNavigatorEntryKeys =
			formNavigatorEntryConfigurationRetriever.getFormNavigatorEntryKeys(
				"form1", "general", "add");

		Assert.assertFalse(formNavigatorEntryKeys.isPresent());
	}

}