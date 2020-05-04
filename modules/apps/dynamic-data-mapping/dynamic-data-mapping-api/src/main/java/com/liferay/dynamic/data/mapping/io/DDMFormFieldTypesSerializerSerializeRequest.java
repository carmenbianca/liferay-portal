/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;

import java.util.List;

/**
 * @author Leonardo Barros
 */
public final class DDMFormFieldTypesSerializerSerializeRequest {

	public List<DDMFormFieldType> getDdmFormFieldTypes() {
		return _ddmFormFieldTypes;
	}

	public static class Builder {

		public static Builder newBuilder(
			List<DDMFormFieldType> ddmFormFieldTypes) {

			return new Builder(ddmFormFieldTypes);
		}

		public DDMFormFieldTypesSerializerSerializeRequest build() {
			return _ddmFormFieldTypesSerializerSerializeRequest;
		}

		private Builder(List<DDMFormFieldType> ddmFormFieldTypes) {
			_ddmFormFieldTypesSerializerSerializeRequest._ddmFormFieldTypes =
				ddmFormFieldTypes;
		}

		private final DDMFormFieldTypesSerializerSerializeRequest
			_ddmFormFieldTypesSerializerSerializeRequest =
				new DDMFormFieldTypesSerializerSerializeRequest();

	}

	private DDMFormFieldTypesSerializerSerializeRequest() {
	}

	private List<DDMFormFieldType> _ddmFormFieldTypes;

}