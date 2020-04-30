/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.LastNameDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.LastNameDSField;
import com.liferay.digital.signature.model.field.builder.LastNameDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class LastNameDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<LastNameDSField>
	implements LastNameDSFieldBuilder {

	public LastNameDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<LastNameDSField> getDSField() {
		LastNameDSFieldImpl lastNameDSFieldImpl = new LastNameDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber());

		populateFields(lastNameDSFieldImpl);

		return lastNameDSFieldImpl;
	}

}