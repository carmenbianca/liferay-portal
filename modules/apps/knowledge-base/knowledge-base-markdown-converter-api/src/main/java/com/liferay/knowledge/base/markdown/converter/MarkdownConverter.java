/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.markdown.converter;

import java.io.IOException;

/**
 * @author James Hinkey
 */
public interface MarkdownConverter {

	public String convert(String markdown) throws IOException;

}