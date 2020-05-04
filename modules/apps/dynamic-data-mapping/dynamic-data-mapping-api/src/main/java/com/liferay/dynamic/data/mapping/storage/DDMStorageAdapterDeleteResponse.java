/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.storage;

/**
 * @author Leonardo Barros
 */
public final class DDMStorageAdapterDeleteResponse {

	public boolean isDeleted() {
		return _deleted;
	}

	public static class Builder {

		public static Builder newBuilder() {
			return new Builder();
		}

		public DDMStorageAdapterDeleteResponse build() {
			return _ddmStorageAdapterDeleteResponse;
		}

		public Builder withDeleted(boolean deleted) {
			_ddmStorageAdapterDeleteResponse._deleted = deleted;

			return this;
		}

		private Builder() {
		}

		private final DDMStorageAdapterDeleteResponse
			_ddmStorageAdapterDeleteResponse =
				new DDMStorageAdapterDeleteResponse();

	}

	private DDMStorageAdapterDeleteResponse() {
	}

	private boolean _deleted = true;

}