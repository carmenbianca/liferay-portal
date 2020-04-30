/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io;

import com.liferay.dynamic.data.mapping.model.DDMFormLayout;

/**
 * @author Leonardo Barros
 */
public final class DDMFormLayoutDeserializerDeserializeResponse {

	public DDMFormLayout getDDMFormLayout() {
		return _ddmFormLayout;
	}

	public static class Builder {

		public static Builder newBuilder(DDMFormLayout ddmFormLayout) {
			return new Builder(ddmFormLayout);
		}

		public DDMFormLayoutDeserializerDeserializeResponse build() {
			return _ddmFormLayoutDeserializerDeserializeResponse;
		}

		private Builder(DDMFormLayout ddmFormLayout) {
			_ddmFormLayoutDeserializerDeserializeResponse._ddmFormLayout =
				ddmFormLayout;
		}

		private final DDMFormLayoutDeserializerDeserializeResponse
			_ddmFormLayoutDeserializerDeserializeResponse =
				new DDMFormLayoutDeserializerDeserializeResponse();

	}

	private DDMFormLayoutDeserializerDeserializeResponse() {
	}

	private DDMFormLayout _ddmFormLayout;

}