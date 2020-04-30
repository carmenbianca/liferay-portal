/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.parser;

/**
 * @author Hugo Huijser
 */
public class JavaStaticBlock extends BaseJavaTerm {

	public JavaStaticBlock(String content, int lineNumber) {
		super(null, content, null, lineNumber, false, true);
	}

}