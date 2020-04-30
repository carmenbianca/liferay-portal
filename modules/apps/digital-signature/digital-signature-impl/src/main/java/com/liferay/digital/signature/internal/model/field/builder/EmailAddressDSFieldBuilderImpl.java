/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.EmailAddressDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.EmailAddressDSField;
import com.liferay.digital.signature.model.field.builder.EmailAddressDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class EmailAddressDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<EmailAddressDSField>
	implements EmailAddressDSFieldBuilder {

	public EmailAddressDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<EmailAddressDSField> getDSField() {
		EmailAddressDSFieldImpl emailAddressDSFieldImpl =
			new EmailAddressDSFieldImpl(
				getDocumentKey(), getFieldKey(), getPageNumber()) {

				{
					setSenderRequired(_senderRequired);
				}
			};

		populateFields(emailAddressDSFieldImpl);

		return emailAddressDSFieldImpl;
	}

	@Override
	public EmailAddressDSFieldBuilder setSenderRequired(
		Boolean senderRequired) {

		_senderRequired = senderRequired;

		return this;
	}

	private Boolean _senderRequired;

}