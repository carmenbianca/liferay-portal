/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.ViewDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.ViewDSField;
import com.liferay.digital.signature.model.field.builder.ViewDSFieldBuilder;

/**
 * @author Michael C. Han
 */
public class ViewDSFieldBuilderImpl
	extends StyledDSFieldBuilderImpl<ViewDSField>
	implements ViewDSFieldBuilder {

	public ViewDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSField<ViewDSField> getDSField() {
		ViewDSFieldImpl viewDSFieldImpl = new ViewDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				setRequiredRead(_requiredRead);
				setViewText(_viewText);
			}
		};

		populateFields(viewDSFieldImpl);

		return viewDSFieldImpl;
	}

	@Override
	public ViewDSFieldBuilder setRequiredRead(Boolean requiredRead) {
		_requiredRead = requiredRead;

		return this;
	}

	@Override
	public ViewDSFieldBuilder setViewText(String viewText) {
		_viewText = viewText;

		return this;
	}

	private Boolean _requiredRead;
	private String _viewText;

}