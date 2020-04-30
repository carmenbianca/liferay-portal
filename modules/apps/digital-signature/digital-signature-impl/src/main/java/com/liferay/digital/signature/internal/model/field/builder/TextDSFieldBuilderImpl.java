/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.TextDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.TextDSField;
import com.liferay.digital.signature.model.field.builder.TextDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class TextDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<TextDSField>
	implements TextDSFieldBuilder {

	public TextDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageText) {

		super(documentKey, fieldKey, pageText);
	}

	@Override
	public DSField<TextDSField> getDSField() {
		TextDSFieldImpl textDSFieldImpl = new TextDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setFormula(_formula);
				setSenderRequired(_senderRequired);
			}
		};

		populateFields(textDSFieldImpl);

		return textDSFieldImpl;
	}

	@Override
	public TextDSFieldBuilder setFormula(String formula) {
		_formula = formula;

		return this;
	}

	@Override
	public TextDSFieldBuilder setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;

		return this;
	}

	private String _formula;
	private Boolean _senderRequired;

}