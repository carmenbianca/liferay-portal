/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.search.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Miguel Pastor
 */
public class KeywordsUtilTest {

	@Test
	public void testEscapeEspecial() {
		Assert.assertEquals(
			"\\{abc \\&& def\\}", KeywordsUtil.escape("{abc && def}"));
	}

	@Test
	public void testEscapeMultipleBracket() {
		Assert.assertEquals("abc\\{", KeywordsUtil.escape("abc{"));
	}

	@Test
	public void testEscapeNoEspecialCharacters() {
		Assert.assertEquals("abc", KeywordsUtil.escape("abc"));
	}

	@Test
	public void testToFuzzyFuzzyText() {
		Assert.assertEquals("abc~", KeywordsUtil.toFuzzy("abc~"));
	}

	@Test
	public void testToFuzzyNonfuzzyText() {
		Assert.assertEquals("abc~", KeywordsUtil.toFuzzy("abc"));
	}

	@Test
	public void testToFuzzyNullText() {
		Assert.assertNull(KeywordsUtil.toFuzzy(null));
	}

	@Test
	public void testToWildcardNullText() {
		Assert.assertNull(KeywordsUtil.toWildcard(null));
	}

	@Test
	public void testToWildcardSimpleText() {
		Assert.assertEquals("abc*", KeywordsUtil.toWildcard("abc"));
	}

	@Test
	public void testToWildcardWildcardText() {
		Assert.assertEquals("abc*", KeywordsUtil.toWildcard("abc*"));
	}

}