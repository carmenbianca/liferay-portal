/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.DeclineDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.DeclineDSField;
import com.liferay.digital.signature.model.field.builder.DeclineDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class DeclineDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<DeclineDSField>
	implements DeclineDSFieldBuilder {

	public DeclineDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<DeclineDSField> getDSField() {
		DeclineDSFieldImpl declineDSFieldImpl = new DeclineDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setDeclineText(_declineText);
			}
		};

		populateFields(declineDSFieldImpl);

		return declineDSFieldImpl;
	}

	@Override
	public DeclineDSFieldBuilder setDeclineText(String declineText) {
		_declineText = declineText;

		return this;
	}

	private String _declineText;

}