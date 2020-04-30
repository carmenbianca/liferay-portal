/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.CheckboxDSFieldImpl;
import com.liferay.digital.signature.model.field.CheckboxDSField;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.builder.CheckboxDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class CheckboxDSFieldBuilderImpl
	extends DSFieldBuilderImpl<CheckboxDSField>
	implements CheckboxDSFieldBuilder {

	public CheckboxDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<CheckboxDSField> getDSField() {
		CheckboxDSFieldImpl checkboxDSFieldImpl = new CheckboxDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setSelected(_selected);
			}
		};

		populateFields(checkboxDSFieldImpl);

		return checkboxDSFieldImpl;
	}

	@Override
	public CheckboxDSFieldBuilder setSelected(Boolean selected) {
		_selected = selected;

		return this;
	}

	private Boolean _selected;

}