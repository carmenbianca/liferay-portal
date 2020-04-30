/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author Alan Huang
 */
public class PropertiesSourceProcessorTest extends BaseSourceProcessorTestCase {

	@Test
	public void testSortDefinitionKeys() throws Exception {
		test("FormatProperties/liferay-plugin-package.testproperties");
		test("FormatProperties/TLiferayBatchFileProperties.testproperties");
	}

	@Test
	public void testStylingCheck() throws Exception {
		test("StylingCheck.testproperties");
	}

}