/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.CheckboxDSField;

/**
 * @author Michael C. Han
 */
public class CheckboxDSFieldImpl
	extends DSFieldImpl<CheckboxDSField> implements CheckboxDSField {

	public CheckboxDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public Boolean getSelected() {
		return _selected;
	}

	public void setSelected(Boolean selected) {
		_selected = selected;
	}

	private Boolean _selected;

}