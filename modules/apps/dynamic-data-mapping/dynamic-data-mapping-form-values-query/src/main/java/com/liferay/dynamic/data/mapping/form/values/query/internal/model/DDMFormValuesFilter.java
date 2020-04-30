/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.values.query.internal.model;

import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;

import java.util.List;

/**
 * @author Pablo Carvalho
 */
public interface DDMFormValuesFilter {

	public List<DDMFormFieldValue> filter(DDMFormValues ddmFormValues);

	public List<DDMFormFieldValue> filter(
		List<DDMFormFieldValue> baseDDMFormFieldValues);

	public boolean isGreedy();

	public void setDDMFormFieldValueMatcher(
		DDMFormFieldValueMatcher ddmFormFieldValueMatcher);

	public void setGreedy(boolean greedy);

}