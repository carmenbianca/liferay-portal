/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.markdown.converter.internal;

import com.liferay.knowledge.base.markdown.converter.MarkdownConverter;
import com.liferay.knowledge.base.markdown.converter.factory.MarkdownConverterFactory;
import com.liferay.knowledge.base.markdown.converter.internal.pegdown.factory.MarkdownConverterFactoryImpl;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Andy Wu
 */
public class MarkdownConverterTest {

	@Test
	public void testLiferayToHtmlSerializer() throws Exception {
		String markdownString =
			"### The liferay-ui:logo-selector Tag Requires Parameter Changes " +
				"[](id=the-liferay-uilogo-selector-tag-requires-parameter-" +
					"changes)";

		MarkdownConverterFactory markdownConverterFactory =
			new MarkdownConverterFactoryImpl();

		MarkdownConverter markdownConverter = markdownConverterFactory.create();

		String html = markdownConverter.convert(markdownString);

		int index = html.indexOf(
			"id=\"the-liferay-uilogo-selector-tag-requires-parameter-" +
				"changes\"");

		Assert.assertNotEquals(-1, index);
	}

}