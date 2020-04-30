/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.filter.QueryFilter;

import java.io.Serializable;

import java.util.Locale;

/**
 * @author Alexander Chow
 */
public interface DDMIndexer {

	public static final String DDM_FIELD_NAMESPACE = "ddm";

	public static final String DDM_FIELD_PREFIX =
		DDM_FIELD_NAMESPACE + DDMIndexer.DDM_FIELD_SEPARATOR;

	public static final String DDM_FIELD_SEPARATOR =
		StringPool.DOUBLE_UNDERLINE;

	public void addAttributes(
		Document document, DDMStructure ddmStructure,
		DDMFormValues ddmFormValues);

	public QueryFilter createFieldValueQueryFilter(
			String ddmStructureFieldName, Serializable ddmStructureFieldValue,
			Locale locale)
		throws Exception;

	public String encodeName(long ddmStructureId, String fieldName);

	public String encodeName(
		long ddmStructureId, String fieldName, Locale locale);

	public String extractIndexableAttributes(
		DDMStructure ddmStructure, DDMFormValues ddmFormValues, Locale locale);

}