/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.FormulaDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.FormulaDSField;
import com.liferay.digital.signature.model.field.builder.FormulaDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class FormulaDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<FormulaDSField>
	implements FormulaDSFieldBuilder {

	public FormulaDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<FormulaDSField> getDSField() {
		FormulaDSFieldImpl formulaDSFieldImpl = new FormulaDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setFormula(_formula);
				setRoundDecimalPlaces(_roundDecimalPlaces);
				setSenderRequired(_senderRequired);
			}
		};

		populateFields(formulaDSFieldImpl);

		return formulaDSFieldImpl;
	}

	@Override
	public FormulaDSFieldBuilder setFormula(String formula) {
		_formula = formula;

		return this;
	}

	@Override
	public FormulaDSFieldBuilder setRoundDecimalPlaces(
		Boolean roundDecimalPlaces) {

		_roundDecimalPlaces = roundDecimalPlaces;

		return this;
	}

	@Override
	public FormulaDSFieldBuilder setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;

		return this;
	}

	private String _formula;
	private Boolean _roundDecimalPlaces;
	private Boolean _senderRequired;

}