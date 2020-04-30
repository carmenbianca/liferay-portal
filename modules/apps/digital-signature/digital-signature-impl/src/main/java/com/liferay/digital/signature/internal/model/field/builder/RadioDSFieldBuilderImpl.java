/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.RadioDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.RadioDSField;
import com.liferay.digital.signature.model.field.builder.RadioDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class RadioDSFieldBuilderImpl
	extends DSFieldBuilderImpl<RadioDSField> implements RadioDSFieldBuilder {

	public RadioDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<RadioDSField> getDSField() {
		RadioDSFieldImpl radioDSFieldImpl = new RadioDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setValue(_value);
			}
		};

		populateFields(radioDSFieldImpl);

		return radioDSFieldImpl;
	}

	@Override
	public RadioDSFieldBuilder setValue(String value) {
		_value = value;

		return this;
	}

	private String _value;

}