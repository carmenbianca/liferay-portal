/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public abstract class BaseJavaLoopStatement
	extends BaseJavaTerm implements JavaLoopStatement {

	@Override
	public String getLabelName() {
		return _labelName;
	}

	@Override
	public void setLabelName(String labelName) {
		_labelName = labelName;
	}

	protected StringBundler appendLabelName(String indent) {
		StringBundler sb = new StringBundler(3);

		if (_labelName != null) {
			sb.append(indent);
			sb.append(_labelName);
			sb.append(":");
		}

		return sb;
	}

	private String _labelName;

}