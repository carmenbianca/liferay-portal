/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.source.formatter.parser.JavaSignature;
import com.liferay.source.formatter.parser.JavaTerm;

/**
 * @author Hugo Huijser
 */
public class JavaIndexableCheck extends BaseJavaTermCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, JavaTerm javaTerm,
		String fileContent) {

		if (fileName.endsWith("LocalServiceImpl.java") &&
			javaTerm.hasAnnotation("Indexable")) {

			JavaSignature signature = javaTerm.getSignature();

			if (Validator.isNull(signature.getReturnType())) {
				addMessage(
					fileName,
					"Missing return type for method '" + javaTerm.getName() +
						"' with @Indexable");
			}
		}

		return javaTerm.getContent();
	}

	@Override
	protected String[] getCheckableJavaTermNames() {
		return new String[] {JAVA_METHOD};
	}

}