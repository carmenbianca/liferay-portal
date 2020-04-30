/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.NoteDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.NoteDSField;
import com.liferay.digital.signature.model.field.builder.NoteDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class NoteDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<NoteDSField>
	implements NoteDSFieldBuilder {

	public NoteDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<NoteDSField> getDSField() {
		NoteDSFieldImpl noteDSFieldImpl = new NoteDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setSenderRequired(_senderRequired);
			}
		};

		populateFields(noteDSFieldImpl);

		return noteDSFieldImpl;
	}

	@Override
	public NoteDSFieldBuilder setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;

		return this;
	}

	private Boolean _senderRequired;

}