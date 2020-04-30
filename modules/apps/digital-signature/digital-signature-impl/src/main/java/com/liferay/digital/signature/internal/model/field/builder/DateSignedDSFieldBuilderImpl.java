/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.DateSignedDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.DateSignedDSField;
import com.liferay.digital.signature.model.field.builder.DateSignedDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class DateSignedDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<DateSignedDSField>
	implements DateSignedDSFieldBuilder {

	public DateSignedDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<DateSignedDSField> getDSField() {
		DateSignedDSFieldImpl dateSignedDSFieldImpl = new DateSignedDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber());

		populateFields(dateSignedDSFieldImpl);

		return dateSignedDSFieldImpl;
	}

}