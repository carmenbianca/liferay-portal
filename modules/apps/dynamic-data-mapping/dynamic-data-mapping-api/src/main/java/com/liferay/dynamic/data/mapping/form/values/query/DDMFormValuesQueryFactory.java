/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.values.query;

import com.liferay.dynamic.data.mapping.storage.DDMFormValues;

/**
 * @author Adolfo Pérez
 */
public interface DDMFormValuesQueryFactory {

	public DDMFormValuesQuery create(DDMFormValues ddmFormValues, String query)
		throws DDMFormValuesQuerySyntaxException;

}