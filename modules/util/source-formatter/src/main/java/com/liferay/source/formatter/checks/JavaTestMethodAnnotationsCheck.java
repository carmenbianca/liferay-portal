/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.source.formatter.parser.JavaClass;
import com.liferay.source.formatter.parser.JavaTerm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JavaTestMethodAnnotationsCheck extends BaseJavaTermCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, JavaTerm javaTerm,
		String fileContent) {

		if (!javaTerm.isPublic() || !fileName.endsWith("Test.java")) {
			return javaTerm.getContent();
		}

		JavaClass parentJavaClass = javaTerm.getParentJavaClass();

		if (parentJavaClass.getParentJavaClass() != null) {
			return javaTerm.getContent();
		}

		_checkAnnotationForMethod(
			fileName, javaTerm, "After", "\\btearDown(?!Class)", false);
		_checkAnnotationForMethod(
			fileName, javaTerm, "AfterClass", "\\btearDownClass", true);
		_checkAnnotationForMethod(
			fileName, javaTerm, "Before", "\\bsetUp(?!Class)", false);
		_checkAnnotationForMethod(
			fileName, javaTerm, "BeforeClass", "\\bsetUpClass", true);
		_checkAnnotationForMethod(fileName, javaTerm, "Test", "^.*test", false);

		return javaTerm.getContent();
	}

	@Override
	protected String[] getCheckableJavaTermNames() {
		return new String[] {JAVA_METHOD};
	}

	private void _checkAnnotationForMethod(
		String fileName, JavaTerm javaTerm, String annotation,
		String requiredMethodNameRegex, boolean staticRequired) {

		String methodName = javaTerm.getName();

		Pattern pattern = Pattern.compile(requiredMethodNameRegex);

		Matcher matcher = pattern.matcher(methodName);

		if (javaTerm.hasAnnotation(annotation)) {
			if (!matcher.find()) {
				addMessage(
					fileName, "Incorrect method name '" + methodName + "'");
			}
			else if (javaTerm.isStatic() != staticRequired) {
				addMessage(
					fileName, "Incorrect method type for '" + methodName + "'");
			}
		}
		else if (matcher.find() && !javaTerm.hasAnnotation("Override")) {
			addMessage(
				fileName,
				StringBundler.concat(
					"Annotation @", annotation, " required for '", methodName,
					"'"));
		}
	}

}