/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.TitleDSField;

/**
 * @author Michael C. Han
 */
public class TitleDSFieldImpl
	extends UserEntryDSFieldImpl<TitleDSField> implements TitleDSField {

	public TitleDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

}