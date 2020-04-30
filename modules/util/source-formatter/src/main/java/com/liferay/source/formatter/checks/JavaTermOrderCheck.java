/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.parser.JavaClass;
import com.liferay.source.formatter.parser.JavaTerm;
import com.liferay.source.formatter.parser.comparator.JavaTermComparator;

import java.io.IOException;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;

/**
 * @author Hugo Huijser
 */
public class JavaTermOrderCheck extends BaseJavaTermCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, JavaTerm javaTerm,
			String fileContent)
		throws DocumentException, IOException {

		String javaTermContent = javaTerm.getContent();

		if (javaTermContent.contains("@Meta.OCD")) {
			return javaTermContent;
		}

		String className = javaTerm.getName();

		String customSQLContent = null;

		if (absolutePath.contains("/persistence/") &&
			className.endsWith("FinderImpl")) {

			Document customSQLDocument = getCustomSQLDocument(
				fileName, absolutePath,
				getPortalCustomSQLDocument(absolutePath));

			if ((customSQLDocument != null) && customSQLDocument.hasContent()) {
				customSQLContent = customSQLDocument.asXML();
			}
		}

		return _sortJavaTerms(
			fileName, absolutePath, (JavaClass)javaTerm, customSQLContent);
	}

	@Override
	protected String[] getCheckableJavaTermNames() {
		return new String[] {JAVA_CLASS};
	}

	private String _sortJavaTerms(
		String fileName, String absolutePath, JavaClass javaClass,
		String customSQLContent) {

		List<JavaTerm> childJavaTerms = javaClass.getChildJavaTerms();

		if (childJavaTerms.size() < 2) {
			return javaClass.getContent();
		}

		JavaTermComparator javaTermComparator = new JavaTermComparator(
			customSQLContent);

		JavaTerm previousJavaTerm = null;

		for (JavaTerm javaTerm : childJavaTerms) {
			if (javaTerm.isJavaStaticBlock() || javaTerm.isDefault()) {
				continue;
			}

			if (previousJavaTerm == null) {
				previousJavaTerm = javaTerm;

				continue;
			}

			int compare = javaTermComparator.compare(
				previousJavaTerm, javaTerm);

			if (compare == 0) {
				addMessage(fileName, "Duplicate " + javaTerm.getName());
			}
			else if (!isExcludedPath(
						JAVATERM_SORT_EXCLUDES, absolutePath,
						previousJavaTerm.getName()) &&
					 !isExcludedPath(
						 JAVATERM_SORT_EXCLUDES, absolutePath,
						 javaTerm.getName()) &&
					 (compare > 0)) {

				String classContent = javaClass.getContent();

				String newClassContent = StringUtil.replaceFirst(
					classContent, "\n" + previousJavaTerm.getContent(),
					"\n" + javaTerm.getContent());

				return StringUtil.replaceLast(
					newClassContent, "\n" + javaTerm.getContent(),
					"\n" + previousJavaTerm.getContent());
			}

			previousJavaTerm = javaTerm;
		}

		return javaClass.getContent();
	}

}