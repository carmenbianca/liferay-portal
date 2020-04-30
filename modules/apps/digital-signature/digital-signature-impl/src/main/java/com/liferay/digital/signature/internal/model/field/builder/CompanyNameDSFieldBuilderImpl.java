/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.CompanyNameDSFieldImpl;
import com.liferay.digital.signature.model.field.CompanyNameDSField;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.builder.CompanyNameDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class CompanyNameDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<CompanyNameDSField>
	implements CompanyNameDSFieldBuilder {

	public CompanyNameDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<CompanyNameDSField> getDSField() {
		CompanyNameDSFieldImpl companyNameDSFieldImpl =
			new CompanyNameDSFieldImpl(
				getDocumentKey(), getFieldKey(), getPageNumber());

		populateFields(companyNameDSFieldImpl);

		return companyNameDSFieldImpl;
	}

}