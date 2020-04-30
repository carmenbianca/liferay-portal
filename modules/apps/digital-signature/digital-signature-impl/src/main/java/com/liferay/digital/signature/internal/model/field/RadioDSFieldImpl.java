/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.RadioDSField;

/**
 * @author Michael C. Han
 */
public class RadioDSFieldImpl
	extends DSFieldImpl<RadioDSField> implements RadioDSField {

	public RadioDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private String _value;

}