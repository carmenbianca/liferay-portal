/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.InitialHereDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.InitialHereDSField;
import com.liferay.digital.signature.model.field.builder.InitialHereDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class InitialHereDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<InitialHereDSField>
	implements InitialHereDSFieldBuilder {

	public InitialHereDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<InitialHereDSField> getDSField() {
		InitialHereDSFieldImpl initialHereDSFieldImpl =
			new InitialHereDSFieldImpl(
				getDocumentKey(), getFieldKey(), getPageNumber()) {

				{
					setScaleValue(_scaleValue);
				}
			};

		populateFields(initialHereDSFieldImpl);

		return initialHereDSFieldImpl;
	}

	@Override
	public InitialHereDSFieldBuilder setScaleValue(Integer scaleValue) {
		_scaleValue = scaleValue;

		return this;
	}

	private Integer _scaleValue;

}