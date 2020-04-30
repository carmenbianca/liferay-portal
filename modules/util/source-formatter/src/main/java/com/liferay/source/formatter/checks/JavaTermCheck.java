/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.parser.JavaClass;

/**
 * @author Hugo Huijser
 */
public interface JavaTermCheck extends SourceCheck {

	public String process(
			String fileName, String absolutePath, JavaClass javaClass,
			String content)
		throws Exception;

}