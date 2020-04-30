/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.InitialHereDSField;

/**
 * @author Michael C. Han
 */
public class InitialHereDSFieldImpl
	extends StyledDSFieldImpl<InitialHereDSField>
	implements InitialHereDSField {

	public InitialHereDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public Integer getScaleValue() {
		return _scaleValue;
	}

	public void setScaleValue(Integer scaleValue) {
		_scaleValue = scaleValue;
	}

	private Integer _scaleValue;

}