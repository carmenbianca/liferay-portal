/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.query;

import java.util.Objects;

/**
 * @author Preston Crary
 */
public class JoinType {

	public static final JoinType INNER = new JoinType("inner");

	public static final JoinType LEFT = new JoinType("left");

	public JoinType(String value) {
		_value = Objects.requireNonNull(value);

		_valueWithJoin = _value.concat(" join ");
	}

	public String getStringWithJoin() {
		return _valueWithJoin;
	}

	@Override
	public String toString() {
		return _value;
	}

	private final String _value;
	private final String _valueWithJoin;

}