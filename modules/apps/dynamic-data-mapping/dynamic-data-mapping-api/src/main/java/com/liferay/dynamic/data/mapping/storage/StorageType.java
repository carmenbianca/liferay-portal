/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.storage;

import java.util.Objects;

/**
 * @author Marcellus Tavares
 * @author Eduardo Lundgren
 */
public enum StorageType {

	JSON("json");

	public static StorageType parse(String value) {
		if (Objects.equals(JSON.getValue(), value)) {
			return JSON;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		return _value;
	}

	private StorageType(String value) {
		_value = value;
	}

	private final String _value;

}