/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.validator;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldValueValidationException;
import com.liferay.dynamic.data.mapping.model.DDMForm;

/**
 * @author Marcellus Tavares
 */
public interface DDMFormValidator {

	public void validate(DDMForm ddmForm)
		throws DDMFormFieldValueValidationException, DDMFormValidationException;

}