/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io;

import com.liferay.dynamic.data.mapping.storage.DDMFormValues;

/**
 * @author Leonardo Barros
 */
public final class DDMFormValuesDeserializerDeserializeResponse {

	public DDMFormValues getDDMFormValues() {
		return _ddmFormValues;
	}

	public static class Builder {

		public static Builder newBuilder(DDMFormValues ddmFormValues) {
			return new Builder(ddmFormValues);
		}

		public DDMFormValuesDeserializerDeserializeResponse build() {
			return _ddmFormValuesDeserializerDeserializeResponse;
		}

		private Builder(DDMFormValues ddmFormValues) {
			_ddmFormValuesDeserializerDeserializeResponse._ddmFormValues =
				ddmFormValues;
		}

		private final DDMFormValuesDeserializerDeserializeResponse
			_ddmFormValuesDeserializerDeserializeResponse =
				new DDMFormValuesDeserializerDeserializeResponse();

	}

	private DDMFormValuesDeserializerDeserializeResponse() {
	}

	private DDMFormValues _ddmFormValues;

}