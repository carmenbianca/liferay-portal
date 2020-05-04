/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.parser.JavaTerm;

/**
 * @author Hugo Huijser
 */
public class JavaConstructorSuperCallCheck extends BaseJavaTermCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, JavaTerm javaTerm,
		String fileContent) {

		String constructorContent = javaTerm.getContent();

		if (constructorContent.contains("\tsuper();")) {
			return StringUtil.removeSubstring(constructorContent, "\tsuper();");
		}

		return constructorContent;
	}

	@Override
	protected String[] getCheckableJavaTermNames() {
		return new String[] {JAVA_CONSTRUCTOR};
	}

}