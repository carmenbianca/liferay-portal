/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.NumberDSField;

/**
 * @author Michael C. Han
 */
public class NumberDSFieldImpl
	extends UserEntryDSFieldImpl<NumberDSField> implements NumberDSField {

	public NumberDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public String getFormula() {
		return _formula;
	}

	@Override
	public Boolean getSenderRequired() {
		return _senderRequired;
	}

	public void setFormula(String formula) {
		_formula = formula;
	}

	public void setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;
	}

	private String _formula;
	private Boolean _senderRequired;

}