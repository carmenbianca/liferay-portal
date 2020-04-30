/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.FullNameDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.FullNameDSField;
import com.liferay.digital.signature.model.field.builder.FullNameDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class FullNameDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<FullNameDSField>
	implements FullNameDSFieldBuilder {

	public FullNameDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<FullNameDSField> getDSField() {
		FullNameDSFieldImpl fullNameDSFieldImpl = new FullNameDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber());

		populateFields(fullNameDSFieldImpl);

		return fullNameDSFieldImpl;
	}

}