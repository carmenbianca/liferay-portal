/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.DeclineDSField;

/**
 * @author Michael C. Han
 */
public class DeclineDSFieldImpl
	extends StyledDSFieldImpl<DeclineDSField> implements DeclineDSField {

	public DeclineDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public String getDeclineText() {
		return _declineText;
	}

	public void setDeclineText(String declineText) {
		_declineText = declineText;
	}

	private String _declineText;

}