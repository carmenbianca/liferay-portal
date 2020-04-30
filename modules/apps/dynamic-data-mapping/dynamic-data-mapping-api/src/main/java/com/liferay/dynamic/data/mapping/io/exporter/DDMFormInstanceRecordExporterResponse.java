/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io.exporter;

/**
 * @author Leonardo Barros
 */
public final class DDMFormInstanceRecordExporterResponse {

	public byte[] getContent() {
		return _content;
	}

	public static class Builder {

		public static Builder newBuilder() {
			return new Builder();
		}

		public DDMFormInstanceRecordExporterResponse build() {
			return _ddmFormInstanceRecordExporterFilterResponse;
		}

		public Builder withContent(byte[] content) {
			_ddmFormInstanceRecordExporterFilterResponse._content = content;

			return this;
		}

		private Builder() {
		}

		private final DDMFormInstanceRecordExporterResponse
			_ddmFormInstanceRecordExporterFilterResponse =
				new DDMFormInstanceRecordExporterResponse();

	}

	private DDMFormInstanceRecordExporterResponse() {
	}

	private byte[] _content;

}