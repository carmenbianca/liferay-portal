/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaImport extends BaseJavaTerm {

	public JavaImport(String name, boolean isStatic) {
		_name = new JavaSimpleValue(name);
		_isStatic = isStatic;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		StringBundler sb = new StringBundler();

		if (_isStatic) {
			append(sb, _name, indent, prefix + "import static ", suffix, -1);
		}
		else {
			append(sb, _name, indent, prefix + "import ", suffix, -1);
		}

		return sb.toString();
	}

	private final boolean _isStatic;
	private final JavaSimpleValue _name;

}