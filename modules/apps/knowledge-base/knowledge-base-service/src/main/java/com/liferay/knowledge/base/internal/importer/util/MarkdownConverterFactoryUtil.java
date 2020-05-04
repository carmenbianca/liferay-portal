/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.importer.util;

import com.liferay.knowledge.base.markdown.converter.MarkdownConverter;
import com.liferay.knowledge.base.markdown.converter.factory.MarkdownConverterFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Matthew Tambara
 */
@Component(immediate = true, service = {})
public class MarkdownConverterFactoryUtil {

	public static MarkdownConverter create() {
		return _markdownConverterFactory.create();
	}

	@Reference(unbind = "-")
	protected void setMarkdownConverterFactory(
		MarkdownConverterFactory markdownConverterFactory) {

		_markdownConverterFactory = markdownConverterFactory;
	}

	private static MarkdownConverterFactory _markdownConverterFactory;

}