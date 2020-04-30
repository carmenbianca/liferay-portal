/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.tools.ImportsFormatter;
import com.liferay.portal.tools.JavaImportsFormatter;
import com.liferay.source.formatter.checks.util.JavaSourceUtil;

import java.io.IOException;

/**
 * @author Hugo Huijser
 */
public class JavaImportsCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		ImportsFormatter importsFormatter = new JavaImportsFormatter();

		String packageName = JavaSourceUtil.getPackageName(content);

		content = importsFormatter.format(
			content, packageName, JavaSourceUtil.getClassName(fileName));

		return StringUtil.replace(content, ";\n/**", ";\n\n/**");
	}

}