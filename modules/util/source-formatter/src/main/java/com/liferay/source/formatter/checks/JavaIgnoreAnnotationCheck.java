/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.parser.JavaClass;
import com.liferay.source.formatter.parser.JavaTerm;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class JavaIgnoreAnnotationCheck extends BaseJavaTermCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, JavaTerm javaTerm,
		String fileContent) {

		if (!javaTerm.hasAnnotation("Ignore") ||
			!javaTerm.hasAnnotation("Test")) {

			return javaTerm.getContent();
		}

		List<String> classNames = getAttributeValues(
			_CLASS_NAMES_BLACKLIST_KEY, absolutePath);

		JavaClass javaClass = javaTerm.getParentJavaClass();

		if (classNames.contains(javaClass.getName(true))) {
			addMessage(
				fileName, "Do not ignore test in '" + javaClass.getName(),
				javaTerm.getLineNumber());
		}

		return javaTerm.getContent();
	}

	@Override
	protected String[] getCheckableJavaTermNames() {
		return new String[] {JAVA_METHOD};
	}

	private static final String _CLASS_NAMES_BLACKLIST_KEY =
		"classNamesBlacklist";

}