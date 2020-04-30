/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.FormulaDSField;

/**
 * @author Michael C. Han
 */
public class FormulaDSFieldImpl
	extends UserEntryDSFieldImpl<FormulaDSField> implements FormulaDSField {

	public FormulaDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public String getFormula() {
		return _formula;
	}

	@Override
	public Boolean getRoundDecimalPlaces() {
		return _roundDecimalPlaces;
	}

	@Override
	public Boolean getSenderRequired() {
		return _senderRequired;
	}

	public void setFormula(String formula) {
		_formula = formula;
	}

	public void setRoundDecimalPlaces(Boolean roundDecimalPlaces) {
		_roundDecimalPlaces = roundDecimalPlaces;
	}

	public void setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;
	}

	private String _formula;
	private Boolean _roundDecimalPlaces;
	private Boolean _senderRequired;

}