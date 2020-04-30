/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.values.query.internal.model;

import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;

/**
 * @author Pablo Carvalho
 */
public class DDMFormFieldValueNameMatcher implements DDMFormFieldValueMatcher {

	@Override
	public boolean matches(DDMFormFieldValue ddmFormFieldValue) {
		return name.equals(ddmFormFieldValue.getName());
	}

	public void setName(String name) {
		this.name = name;
	}

	public String name;

}