/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.util;

/**
 * @author Hugo Huijser
 */
public enum CheckType {

	CHECKSTYLE("Checkstyle"), SOURCE_CHECK("SourceCheck");

	public String getValue() {
		return _value;
	}

	private CheckType(String value) {
		_value = value;
	}

	private final String _value;

}