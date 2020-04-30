/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.DateDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.DateDSField;
import com.liferay.digital.signature.model.field.builder.DateDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class DateDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<DateDSField>
	implements DateDSFieldBuilder {

	public DateDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<DateDSField> getDSField() {
		DateDSFieldImpl dateDSFieldImpl = new DateDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setSenderRequired(_senderRequired);
			}
		};

		populateFields(dateDSFieldImpl);

		return dateDSFieldImpl;
	}

	@Override
	public DateDSFieldBuilder setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;

		return this;
	}

	private Boolean _senderRequired;

}