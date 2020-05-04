/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.unit.converter.web.internal.model;

/**
 * @author James Lefeu
 */
public class UnitConverter {

	public UnitConverter(int type, int fromId, int toId, double fromValue) {
		_type = type;
		_fromId = fromId;
		_toId = toId;
		_fromValue = fromValue;
	}

	public UnitConverter(
		int type, int fromId, int toId, double fromValue, double toValue) {

		_type = type;
		_fromId = fromId;
		_toId = toId;
		_fromValue = fromValue;
		_toValue = toValue;
	}

	public int getFromId() {
		return _fromId;
	}

	public double getFromValue() {
		return _fromValue;
	}

	public int getToId() {
		return _toId;
	}

	public double getToValue() {
		return _toValue;
	}

	public int getType() {
		return _type;
	}

	public void setFromValue(double fromValue) {
		_fromValue = fromValue;
	}

	public void setToValue(double toValue) {
		_toValue = toValue;
	}

	private final int _fromId;
	private double _fromValue;
	private final int _toId;
	private double _toValue;
	private final int _type;

}