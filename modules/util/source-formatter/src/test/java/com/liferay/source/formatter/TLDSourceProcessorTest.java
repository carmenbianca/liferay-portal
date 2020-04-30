/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author David Zhang
 */
public class TLDSourceProcessorTest extends BaseSourceProcessorTestCase {

	@Test
	public void testIncorrectEmptyLines() throws Exception {
		test("IncorrectEmptyLines.testtld");
	}

}