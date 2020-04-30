/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

/**
 * @author Hugo Huijser
 */
public class JSWhitespaceCheck extends WhitespaceCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		content = StringUtil.replace(
			content,
			new String[] {
				StringPool.TAB + "else{", StringPool.TAB + "for(",
				StringPool.TAB + "if(", StringPool.TAB + "while(",
				" function (", "){\n", "= new Array();", "= new Object();"
			},
			new String[] {
				StringPool.TAB + "else {", StringPool.TAB + "for (",
				StringPool.TAB + "if (", StringPool.TAB + "while (",
				" function(", ") {\n", "= [];", "= {};"
			});

		return super.doProcess(fileName, absolutePath, content);
	}

}