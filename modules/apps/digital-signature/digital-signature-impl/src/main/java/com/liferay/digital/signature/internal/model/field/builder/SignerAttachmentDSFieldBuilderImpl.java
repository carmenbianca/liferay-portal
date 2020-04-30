/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.SignerAttachmentDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.SignerAttachmentDSField;
import com.liferay.digital.signature.model.field.builder.SignerAttachmentDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class SignerAttachmentDSFieldBuilderImpl
	extends DSFieldBuilderImpl<SignerAttachmentDSField>
	implements SignerAttachmentDSFieldBuilder {

	public SignerAttachmentDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<SignerAttachmentDSField> getDSField() {
		SignerAttachmentDSFieldImpl signerAttachmentDSFieldImpl =
			new SignerAttachmentDSFieldImpl(
				getDocumentKey(), getFieldKey(), getPageNumber()) {

				{
					setOptional(_optional);
				}
			};

		populateFields(signerAttachmentDSFieldImpl);

		return signerAttachmentDSFieldImpl;
	}

	@Override
	public SignerAttachmentDSFieldBuilder setOptional(Boolean optional) {
		_optional = optional;

		return this;
	}

	private Boolean _optional;

}