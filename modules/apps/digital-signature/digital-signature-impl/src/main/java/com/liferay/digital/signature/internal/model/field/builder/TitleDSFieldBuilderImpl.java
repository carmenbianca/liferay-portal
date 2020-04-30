/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.TitleDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.TitleDSField;
import com.liferay.digital.signature.model.field.builder.TitleDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class TitleDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<TitleDSField>
	implements TitleDSFieldBuilder {

	public TitleDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<TitleDSField> getDSField() {
		TitleDSFieldImpl titleDSFieldImpl = new TitleDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber());

		populateFields(titleDSFieldImpl);

		return titleDSFieldImpl;
	}

}