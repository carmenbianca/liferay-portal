/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.theme;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class ThemeCompanyId implements Serializable {

	public ThemeCompanyId(String value, boolean pattern) {
		_value = value;
		_pattern = pattern;
	}

	public String getValue() {
		return _value;
	}

	public boolean isPattern() {
		return _pattern;
	}

	private final boolean _pattern;
	private final String _value;

}