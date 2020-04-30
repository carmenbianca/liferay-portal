/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Thrown when the system identifies a violation of the Record Set Key unique
 * property.
 *
 * @author Brian Wing Shun Chan
 */
public class RecordSetDuplicateRecordSetKeyException extends PortalException {

	public RecordSetDuplicateRecordSetKeyException() {
	}

	public RecordSetDuplicateRecordSetKeyException(String msg) {
		super(msg);
	}

	public RecordSetDuplicateRecordSetKeyException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public RecordSetDuplicateRecordSetKeyException(Throwable cause) {
		super(cause);
	}

	public String getRecordSetKey() {
		return _recordSetKey;
	}

	public void setRecordSetKey(String recordSetKey) {
		_recordSetKey = recordSetKey;
	}

	private String _recordSetKey;

}