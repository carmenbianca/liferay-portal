/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaBreakStatement extends BaseJavaTerm {

	public void setIdentifierName(String identifierName) {
		_identifierName = new JavaSimpleValue(identifierName);
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		if (_identifierName == null) {
			return StringBundler.concat(indent, prefix, "break", suffix);
		}

		return _identifierName.toString(
			indent, prefix + "break ", suffix, maxLineLength);
	}

	private JavaSimpleValue _identifierName;

}