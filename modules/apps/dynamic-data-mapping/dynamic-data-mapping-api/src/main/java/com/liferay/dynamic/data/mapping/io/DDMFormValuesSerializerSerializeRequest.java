/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io;

import com.liferay.dynamic.data.mapping.storage.DDMFormValues;

/**
 * @author Leonardo Barros
 */
public final class DDMFormValuesSerializerSerializeRequest {

	public DDMFormValues getDDMFormValues() {
		return _ddmFormValues;
	}

	public static class Builder {

		public static Builder newBuilder(DDMFormValues ddmFormValues) {
			return new Builder(ddmFormValues);
		}

		public DDMFormValuesSerializerSerializeRequest build() {
			return _ddmFormValuesSerializerSerializeRequest;
		}

		private Builder(DDMFormValues ddmFormValues) {
			_ddmFormValuesSerializerSerializeRequest._ddmFormValues =
				ddmFormValues;
		}

		private final DDMFormValuesSerializerSerializeRequest
			_ddmFormValuesSerializerSerializeRequest =
				new DDMFormValuesSerializerSerializeRequest();

	}

	private DDMFormValuesSerializerSerializeRequest() {
	}

	private DDMFormValues _ddmFormValues;

}