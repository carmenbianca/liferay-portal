/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Hugo Huijser
 */
public class JavaInstanceInitialization extends BaseJavaTerm {

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		return StringBundler.concat(
			indent, prefix, StringUtil.trimLeading(suffix));
	}

}