/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.select;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldOptionsValidationTestCase;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldValueValidator;
import com.liferay.portal.json.JSONFactoryImpl;

import org.junit.Before;

/**
 * @author Marcellus Tavares
 */
public class SelectDDMFormFieldValueValidatorTest
	extends BaseDDMFormFieldOptionsValidationTestCase {

	@Before
	public void setUp() {
		setUpDDMFormFieldValueValidator();
	}

	@Override
	protected DDMFormFieldValueValidator getDDMFormFieldValueValidator() {
		return _selectDDMFormFieldValueValidator;
	}

	protected void setUpDDMFormFieldValueValidator() {
		_selectDDMFormFieldValueValidator.jsonFactory = new JSONFactoryImpl();
	}

	private final SelectDDMFormFieldValueValidator
		_selectDDMFormFieldValueValidator =
			new SelectDDMFormFieldValueValidator();

}