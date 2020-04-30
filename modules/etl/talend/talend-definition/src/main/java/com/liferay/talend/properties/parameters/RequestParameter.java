/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.properties.parameters;

import java.util.Objects;

/**
 * @author Igor Beslic
 */
public class RequestParameter {

	public RequestParameter(String location, String name, String value) {
		_location = location;
		_name = name;
		_value = value;
	}

	public String getLocation() {
		return _location;
	}

	public String getName() {
		if (_name.endsWith("*")) {
			return _name.substring(0, _name.length() - 1);
		}

		return _name;
	}

	public String getValue() {
		return _value;
	}

	public boolean isPathLocation() {
		if (Objects.equals("path", _location)) {
			return true;
		}

		return false;
	}

	private final String _location;
	private final String _name;
	private final String _value;

}