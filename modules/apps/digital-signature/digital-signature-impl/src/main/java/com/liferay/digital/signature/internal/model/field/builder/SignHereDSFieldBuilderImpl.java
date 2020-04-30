/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.SignHereDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.SignHereDSField;
import com.liferay.digital.signature.model.field.builder.SignHereDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class SignHereDSFieldBuilderImpl
	extends DSFieldBuilderImpl<SignHereDSField>
	implements SignHereDSFieldBuilder {

	public SignHereDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<SignHereDSField> getDSField() {
		SignHereDSFieldImpl signHereDSFieldImpl = new SignHereDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setOptional(_optional);
			}
		};

		populateFields(signHereDSFieldImpl);

		return signHereDSFieldImpl;
	}

	@Override
	public SignHereDSFieldBuilder setOptional(Boolean optional) {
		_optional = optional;

		return this;
	}

	private Boolean _optional;

}