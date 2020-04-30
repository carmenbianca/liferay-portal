/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider;

import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.util.DDMFormInstanceFactory;

/**
 * @author Marcellus Tavares
 */
public class DDMDataProviderContext {

	public DDMDataProviderContext(DDMFormValues ddmFormValues) {
		_ddmFormValues = ddmFormValues;
	}

	public <T> T getSettingsInstance(Class<T> clazz) {
		return DDMFormInstanceFactory.create(clazz, _ddmFormValues);
	}

	private final DDMFormValues _ddmFormValues;

}