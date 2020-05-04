/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.sort;

import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Jorge Ferrer
 */
public class Sort implements Serializable {

	public Sort(String fieldName, boolean reverse) {
		_fieldName = fieldName;
		_reverse = reverse;
	}

	public String getFieldName() {
		return _fieldName;
	}

	public boolean isReverse() {
		return _reverse;
	}

	public void setFieldName(String fieldName) {
		_fieldName = fieldName;
	}

	public void setReverse(boolean reverse) {
		_reverse = reverse;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{fieldName=");
		sb.append(_fieldName);
		sb.append(", reverse=");
		sb.append(_reverse);
		sb.append("}");

		return sb.toString();
	}

	private String _fieldName;
	private boolean _reverse;

}