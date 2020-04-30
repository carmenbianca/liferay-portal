/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.SignHereDSField;

/**
 * @author Michael C. Han
 */
public class SignHereDSFieldImpl
	extends DSFieldImpl<SignHereDSField> implements SignHereDSField {

	public SignHereDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public Boolean getOptional() {
		return _optional;
	}

	public void setOptional(Boolean optional) {
		_optional = optional;
	}

	private Boolean _optional;

}