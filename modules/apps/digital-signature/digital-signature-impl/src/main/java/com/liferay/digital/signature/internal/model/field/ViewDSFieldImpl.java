/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.ViewDSField;

/**
 * @author Michael C. Han
 */
public class ViewDSFieldImpl
	extends StyledDSFieldImpl<ViewDSField> implements ViewDSField {

	public ViewDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public Boolean getRequiredRead() {
		return _requiredRead;
	}

	@Override
	public String getViewText() {
		return _viewText;
	}

	public void setRequiredRead(Boolean requiredRead) {
		_requiredRead = requiredRead;
	}

	public void setViewText(String viewText) {
		_viewText = viewText;
	}

	private Boolean _requiredRead;
	private String _viewText;

}