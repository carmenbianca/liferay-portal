/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.SignaturePackageKeyDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.SignaturePackageKeyDSField;
import com.liferay.digital.signature.model.field.builder.SignaturePackageKeyDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class SignaturePackageKeyDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<SignaturePackageKeyDSField>
	implements SignaturePackageKeyDSFieldBuilder {

	public SignaturePackageKeyDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<SignaturePackageKeyDSField> getDSField() {
		SignaturePackageKeyDSFieldImpl signaturePackageKeyDSFieldImpl =
			new SignaturePackageKeyDSFieldImpl(
				getDocumentKey(), getFieldKey(), getPageNumber());

		populateFields(signaturePackageKeyDSFieldImpl);

		return signaturePackageKeyDSFieldImpl;
	}

}