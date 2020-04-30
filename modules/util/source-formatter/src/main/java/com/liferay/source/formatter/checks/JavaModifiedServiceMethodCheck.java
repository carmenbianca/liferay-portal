/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.parser.JavaTerm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JavaModifiedServiceMethodCheck extends BaseJavaTermCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, JavaTerm javaTerm,
		String fileContent) {

		String javaTermContent = javaTerm.getContent();

		String methodName = javaTerm.getName();

		if (!methodName.equals("modifiedService")) {
			return javaTermContent;
		}

		Matcher matcher = _missingEmptyLinePattern.matcher(javaTermContent);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				javaTermContent, "\n", "\n\n", matcher.start(1));
		}

		return javaTermContent;
	}

	@Override
	protected String[] getCheckableJavaTermNames() {
		return new String[] {JAVA_METHOD};
	}

	private static final Pattern _missingEmptyLinePattern = Pattern.compile(
		"\tremovedService\\([^;]+;(\n)\t+addingService\\(");

}