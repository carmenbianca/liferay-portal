/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.PostalCodeDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.PostalCodeDSField;
import com.liferay.digital.signature.model.field.builder.PostalCodeDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class PostalCodeDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<PostalCodeDSField>
	implements PostalCodeDSFieldBuilder {

	public PostalCodeDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<PostalCodeDSField> getDSField() {
		PostalCodeDSFieldImpl postalCodeDSFieldImpl = new PostalCodeDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setSenderRequired(_senderRequired);
			}
		};

		populateFields(postalCodeDSFieldImpl);

		return postalCodeDSFieldImpl;
	}

	@Override
	public PostalCodeDSFieldBuilder setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;

		return this;
	}

	private Boolean _senderRequired;

}