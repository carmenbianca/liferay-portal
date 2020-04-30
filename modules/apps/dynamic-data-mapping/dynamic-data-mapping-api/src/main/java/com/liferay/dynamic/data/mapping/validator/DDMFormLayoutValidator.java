/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.validator;

import com.liferay.dynamic.data.mapping.model.DDMFormLayout;

/**
 * @author Pablo Carvalho
 */
public interface DDMFormLayoutValidator {

	public void validate(DDMFormLayout ddmFormLayout)
		throws DDMFormLayoutValidationException;

}