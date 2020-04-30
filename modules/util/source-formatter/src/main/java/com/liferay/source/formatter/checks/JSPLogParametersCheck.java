/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.source.formatter.checks.util.JSPSourceUtil;

/**
 * @author Hugo Huijser
 */
public class JSPLogParametersCheck extends BaseLogParametersCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		return formatLogParameters(content);
	}

	@Override
	protected boolean isJavaSource(String content, int pos) {
		return JSPSourceUtil.isJavaSource(content, pos);
	}

}