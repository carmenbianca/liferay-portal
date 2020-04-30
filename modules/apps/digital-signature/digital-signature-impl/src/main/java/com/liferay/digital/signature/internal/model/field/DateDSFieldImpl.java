/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.DateDSField;

/**
 * @author Michael C. Han
 */
public class DateDSFieldImpl
	extends UserEntryDSFieldImpl<DateDSField> implements DateDSField {

	public DateDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public Boolean getSenderRequired() {
		return _senderRequired;
	}

	public void setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;
	}

	private Boolean _senderRequired;

}