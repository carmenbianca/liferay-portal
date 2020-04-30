/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.markdown.converter.factory;

import com.liferay.knowledge.base.markdown.converter.MarkdownConverter;

/**
 * @author Sergio González
 */
public interface MarkdownConverterFactory {

	public MarkdownConverter create();

}