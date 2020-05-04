/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.analysis;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class SimpleKeywordTokenizerTest {

	@Test
	public void testJapaneseIdeographicSpace() {
		String ideographicSpace = "\u3000";

		assertTokenize(ideographicSpace, "[]");
		assertTokenize("simple" + ideographicSpace + "test", "[simple, test]");
		assertTokenize(
			"\"simple\"" + ideographicSpace + "\"test\"",
			"[\"simple\", \"test\"]");
		assertTokenize(
			StringBundler.concat(
				"This", ideographicSpace, "is \"a", ideographicSpace,
				"simple\"", ideographicSpace, "token", ideographicSpace,
				"\"test\""),
			"[This, is, \"a simple\", token, \"test\"]");
	}

	@Test
	public void testRequiresTokenization() {
		Assert.assertTrue(requiresTokenization("This is a simple test"));
		Assert.assertTrue(requiresTokenization("This \"is a simple\" test"));
		Assert.assertFalse(requiresTokenization("\"is a simple\""));
	}

	@Test
	public void testTokenize() {
		assertTokenize(
			"This is a simple token test",
			"[This, is, a, simple, token, test]");
	}

	@Test(expected = NullPointerException.class)
	public void testTokenizeNull() {
		simpleKeywordTokenizer.tokenize(null);
	}

	@Test
	public void testTokenizeStringBlank() {
		assertTokenize(StringPool.BLANK, "[]");
	}

	@Test
	public void testTokenizeStringNull() {
		assertTokenize(StringPool.NULL, "[null]");
	}

	@Test
	public void testTokenizeWithQuote() {
		assertTokenize(
			"This is a \"simple token\" test",
			"[This, is, a, \"simple token\", test]");

		assertTokenize(
			"This \"is a\" simple token test",
			"[This, \"is a\", simple, token, test]");

		assertTokenize(
			"\"This is a token test\"", "[\"This is a token test\"]");
	}

	@Test
	public void testTokenizeWithQuoteAndMixedSpace() {
		assertTokenize(
			"This   is  a \"simple token\"   test",
			"[This, is, a, \"simple token\", test]");

		assertTokenize(
			"This  is a \"simple   token\"  test",
			"[This, is, a, \"simple   token\", test]");
	}

	@Test
	public void testTokenizeWithSeveralQuotes() {
		assertTokenize(
			"\"   This is   \"   a   \"   token test   \"",
			"[\"   This is   \", a, \"   token test   \"]");
	}

	protected void assertTokenize(String string, String expected) {
		List<String> tokens = simpleKeywordTokenizer.tokenize(string);

		Assert.assertEquals(expected, tokens.toString());
	}

	protected boolean requiresTokenization(String string) {
		return simpleKeywordTokenizer.requiresTokenization(string);
	}

	protected final SimpleKeywordTokenizer simpleKeywordTokenizer =
		new SimpleKeywordTokenizer();

}