/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.NotarizeDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.NotarizeDSField;
import com.liferay.digital.signature.model.field.builder.NotarizeDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class NotarizeDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<NotarizeDSField>
	implements NotarizeDSFieldBuilder {

	public NotarizeDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<NotarizeDSField> getDSField() {
		NotarizeDSFieldImpl notarizeDSFieldImpl = new NotarizeDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber());

		populateFields(notarizeDSFieldImpl);

		return notarizeDSFieldImpl;
	}

}