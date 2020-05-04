/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author     Brian Wing Shun Chan
 * @deprecated As of Judson (7.1.x), replaced by {@link
 *             com.liferay.trash.exception.RestoreEntryException}
 */
@Deprecated
public class RestoreEntryException extends PortalException {

	public static final int DUPLICATE = 1;

	public static final int INVALID_CONTAINER = 2;

	public static final int INVALID_NAME = 3;

	public static final int INVALID_STATUS = 4;

	public RestoreEntryException() {
	}

	public RestoreEntryException(int type) {
		_type = type;
	}

	public RestoreEntryException(int type, Throwable cause) {
		super(cause);

		_type = type;
	}

	public RestoreEntryException(String msg) {
		super(msg);
	}

	public RestoreEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RestoreEntryException(Throwable cause) {
		super(cause);
	}

	public long getDuplicateEntryId() {
		return _duplicateEntryId;
	}

	public String getErrorMessage() {
		return _errorMessage;
	}

	public String getOldName() {
		return _oldName;
	}

	public long getTrashEntryId() {
		return _trashEntryId;
	}

	public int getType() {
		return _type;
	}

	public boolean isOverridable() {
		return _overridable;
	}

	public void setDuplicateEntryId(long duplicateEntryId) {
		_duplicateEntryId = duplicateEntryId;
	}

	public void setErrorMessage(String errorMessage) {
		_errorMessage = errorMessage;
	}

	public void setOldName(String oldName) {
		_oldName = oldName;
	}

	public void setOverridable(boolean overridable) {
		_overridable = overridable;
	}

	public void setTrashEntryId(long trashEntryId) {
		_trashEntryId = trashEntryId;
	}

	public void setType(int type) {
		_type = type;
	}

	private long _duplicateEntryId;
	private String _errorMessage;
	private String _oldName;
	private boolean _overridable = true;
	private long _trashEntryId;
	private int _type;

}