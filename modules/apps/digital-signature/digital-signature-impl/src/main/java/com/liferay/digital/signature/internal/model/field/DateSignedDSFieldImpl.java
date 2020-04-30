/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.DateSignedDSField;

/**
 * @author Michael C. Han
 */
public class DateSignedDSFieldImpl
	extends StyledDSFieldImpl<DateSignedDSField> implements DateSignedDSField {

	public DateSignedDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

}