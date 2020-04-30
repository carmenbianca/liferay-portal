/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.radio;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldOptionsValidationTestCase;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldValueValidator;

/**
 * @author Marcellus Tavares
 */
public class RadioDDMFormFieldValueValidatorTest
	extends BaseDDMFormFieldOptionsValidationTestCase {

	@Override
	protected DDMFormFieldValueValidator getDDMFormFieldValueValidator() {
		return _radioDDMFormFieldValueValidator;
	}

	private final RadioDDMFormFieldValueValidator
		_radioDDMFormFieldValueValidator =
			new RadioDDMFormFieldValueValidator();

}