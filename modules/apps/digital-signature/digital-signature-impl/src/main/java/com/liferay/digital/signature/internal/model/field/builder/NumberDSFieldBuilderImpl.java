/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.NumberDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.NumberDSField;
import com.liferay.digital.signature.model.field.builder.NumberDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class NumberDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<NumberDSField>
	implements NumberDSFieldBuilder {

	public NumberDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<NumberDSField> getDSField() {
		NumberDSFieldImpl numberDSFieldImpl = new NumberDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setFormula(_formula);
				setSenderRequired(_senderRequired);
			}
		};

		populateFields(numberDSFieldImpl);

		return numberDSFieldImpl;
	}

	@Override
	public NumberDSFieldBuilder setFormula(String formula) {
		_formula = formula;

		return this;
	}

	@Override
	public NumberDSFieldBuilder setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;

		return this;
	}

	private String _formula;
	private Boolean _senderRequired;

}