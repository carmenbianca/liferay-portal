/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.checks.util.JavaSourceUtil;
import com.liferay.source.formatter.parser.JavaClass;
import com.liferay.source.formatter.parser.JavaTerm;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class JavaModuleComponentCheck extends BaseJavaTermCheck {

	@Override
	public boolean isModuleSourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, JavaTerm javaTerm,
		String fileContent) {

		if (javaTerm.getParentJavaClass() != null) {
			return javaTerm.getContent();
		}

		String packageName = JavaSourceUtil.getPackageName(fileContent);

		List<String> allowedClassNames = getAttributeValues(
			_ALLOWED_CLASS_NAMES_KEY, absolutePath);

		if (allowedClassNames.contains(
				packageName + "." + javaTerm.getName())) {

			return javaTerm.getContent();
		}

		if (javaTerm.hasAnnotation("Component")) {
			if (absolutePath.contains("-api/") ||
				absolutePath.contains("-spi/")) {

				addMessage(
					fileName,
					"Do not use @Component in '-api' or '-spi' module");
			}
		}
		else if (!javaTerm.isAbstract()) {
			JavaClass javaClass = (JavaClass)javaTerm;

			for (JavaTerm childJavaTerm : javaClass.getChildJavaTerms()) {
				if (childJavaTerm.hasAnnotation("Reference")) {
					addMessage(
						fileName,
						"@Reference should not be used in a class without " +
							"@Component");

					break;
				}
			}
		}

		return javaTerm.getContent();
	}

	@Override
	protected String[] getCheckableJavaTermNames() {
		return new String[] {JAVA_CLASS};
	}

	private static final String _ALLOWED_CLASS_NAMES_KEY = "allowedClassNames";

}