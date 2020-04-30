/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class StorageFieldValueException extends StorageException {

	public StorageFieldValueException() {
	}

	public StorageFieldValueException(String msg) {
		super(msg);
	}

	public StorageFieldValueException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public StorageFieldValueException(Throwable cause) {
		super(cause);
	}

	public static class RequiredValue extends StorageFieldValueException {

		public RequiredValue(String fieldName) {
			super(String.format("No value defined for field %s", fieldName));

			_fieldName = fieldName;
		}

		public String getFieldName() {
			return _fieldName;
		}

		private final String _fieldName;

	}

}