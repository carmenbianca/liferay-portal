/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.util.FileImpl;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tina Tian
 */
public class URLResourceParserTest {

	@Test
	public void testIsTemplateResourceValid() {
		FileUtil fileUtil = new FileUtil();

		fileUtil.setFile(FileImpl.getInstance());

		URLResourceParser urlResourceParser = new URLResourceParser() {

			@Override
			public URL getURL(String templateId) {
				return null;
			}

		};

		for (String langType : TemplateConstants.ALLOWED_LANG_TYPES) {
			Assert.assertTrue(
				urlResourceParser.isTemplateResourceValid(
					"_SEPARATOR_/template." + langType, langType));
			Assert.assertFalse(
				urlResourceParser.isTemplateResourceValid(
					"portal-ext.properties", langType));
		}

		Assert.assertTrue(
			urlResourceParser.isTemplateResourceValid(
				"_SEPARATOR_/template.custom", "custom"));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"..\\file", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"../\\file", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"..\\/file", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"\\..\\file", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"/..\\file", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"\\../\\file", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"\\..\\/file", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"%2f..%2ffile", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"/file?a=.ftl", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"/file#a=.ftl", StringPool.BLANK));
		Assert.assertFalse(
			urlResourceParser.isTemplateResourceValid(
				"/file;a=.ftl", StringPool.BLANK));
	}

	@Test
	public void testNormalizePath() {
		Assert.assertEquals(
			"abc", ClassLoaderResourceParser.normalizePath("abc"));
		Assert.assertEquals(
			"/abc", ClassLoaderResourceParser.normalizePath("/abc"));

		try {
			ClassLoaderResourceParser.normalizePath("//");

			Assert.fail();
		}
		catch (IllegalArgumentException illegalArgumentException) {
			Assert.assertEquals(
				"Unable to parse path //",
				illegalArgumentException.getMessage());
		}

		Assert.assertEquals(
			"abc", ClassLoaderResourceParser.normalizePath("abc/./"));
		Assert.assertEquals(
			"def", ClassLoaderResourceParser.normalizePath("abc/../def"));

		try {
			ClassLoaderResourceParser.normalizePath("../");

			Assert.fail();
		}
		catch (IllegalArgumentException illegalArgumentException) {
			Assert.assertEquals(
				"Unable to parse path ../",
				illegalArgumentException.getMessage());
		}

		Assert.assertEquals(
			"/efg/hij",
			ClassLoaderResourceParser.normalizePath("/abc/../efg/./hij/"));
	}

}