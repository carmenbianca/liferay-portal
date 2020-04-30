/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.FullNameDSField;

/**
 * @author Michael C. Han
 */
public class FullNameDSFieldImpl
	extends StyledDSFieldImpl<FullNameDSField> implements FullNameDSField {

	public FullNameDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

}