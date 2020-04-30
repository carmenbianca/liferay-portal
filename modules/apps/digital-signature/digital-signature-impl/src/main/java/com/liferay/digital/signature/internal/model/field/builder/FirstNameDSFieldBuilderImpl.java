/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.FirstNameDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.FirstNameDSField;
import com.liferay.digital.signature.model.field.builder.FirstNameDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class FirstNameDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<FirstNameDSField>
	implements FirstNameDSFieldBuilder {

	public FirstNameDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<FirstNameDSField> getDSField() {
		FirstNameDSFieldImpl firstNameDSFieldImpl = new FirstNameDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber());

		populateFields(firstNameDSFieldImpl);

		return firstNameDSFieldImpl;
	}

}