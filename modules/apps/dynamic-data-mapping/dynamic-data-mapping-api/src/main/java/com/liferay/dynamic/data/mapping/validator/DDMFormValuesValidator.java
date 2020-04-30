/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.validator;

import com.liferay.dynamic.data.mapping.storage.DDMFormValues;

/**
 * @author Marcellus Tavares
 */
public interface DDMFormValuesValidator {

	public void validate(DDMFormValues ddmFormValues)
		throws DDMFormValuesValidationException;

}