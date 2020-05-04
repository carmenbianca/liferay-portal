/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io;

/**
 * @author Leonardo Barros
 */
public final class DDMFormLayoutSerializerSerializeResponse {

	public String getContent() {
		return _content;
	}

	public static class Builder {

		public static Builder newBuilder(String content) {
			return new Builder(content);
		}

		public DDMFormLayoutSerializerSerializeResponse build() {
			return _ddmFormLayoutSerializerSerializeResponse;
		}

		private Builder(String content) {
			_ddmFormLayoutSerializerSerializeResponse._content = content;
		}

		private final DDMFormLayoutSerializerSerializeResponse
			_ddmFormLayoutSerializerSerializeResponse =
				new DDMFormLayoutSerializerSerializeResponse();

	}

	private DDMFormLayoutSerializerSerializeResponse() {
	}

	private String _content;

}