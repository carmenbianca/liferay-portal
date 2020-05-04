/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io;

/**
 * @author Leonardo Barros
 */
public final class DDMFormDeserializerDeserializeRequest {

	public String getContent() {
		return _content;
	}

	public static class Builder {

		public static Builder newBuilder(String content) {
			return new Builder(content);
		}

		public DDMFormDeserializerDeserializeRequest build() {
			return _ddmFormDeserializerDeserializeRequest;
		}

		private Builder(String content) {
			_ddmFormDeserializerDeserializeRequest._content = content;
		}

		private final DDMFormDeserializerDeserializeRequest
			_ddmFormDeserializerDeserializeRequest =
				new DDMFormDeserializerDeserializeRequest();

	}

	private DDMFormDeserializerDeserializeRequest() {
	}

	private String _content;

}