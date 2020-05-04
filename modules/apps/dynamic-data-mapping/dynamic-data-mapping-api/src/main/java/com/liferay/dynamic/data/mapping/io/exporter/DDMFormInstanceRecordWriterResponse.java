/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io.exporter;

/**
 * @author Leonardo Barros
 */
public final class DDMFormInstanceRecordWriterResponse {

	public byte[] getContent() {
		return _content;
	}

	public static class Builder {

		public static Builder newBuilder(byte[] content) {
			return new Builder(content);
		}

		public DDMFormInstanceRecordWriterResponse build() {
			return _ddmFormInstanceRecordWriterResponse;
		}

		private Builder(byte[] content) {
			_ddmFormInstanceRecordWriterResponse._content = content;
		}

		private final DDMFormInstanceRecordWriterResponse
			_ddmFormInstanceRecordWriterResponse =
				new DDMFormInstanceRecordWriterResponse();

	}

	private DDMFormInstanceRecordWriterResponse() {
	}

	private byte[] _content;

}