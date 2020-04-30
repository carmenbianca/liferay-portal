/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.checks.util.JavaSourceUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JavaLogClassNameCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		Matcher matcher = _logPattern.matcher(content);

		if (matcher.find()) {
			String className = JavaSourceUtil.getClassName(fileName);
			String logClassName = matcher.group(1);

			if (!logClassName.equals(className)) {
				content = StringUtil.replaceLast(
					content, logClassName + ".class)", className + ".class)");
			}
		}

		return content;
	}

	private static final Pattern _logPattern = Pattern.compile(
		"\n\tprivate static final Log _log = LogFactoryUtil.getLog\\(\n*" +
			"\t*(.+)\\.class\\)");

}