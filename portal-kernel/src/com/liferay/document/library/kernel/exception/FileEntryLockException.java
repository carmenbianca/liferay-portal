/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FileEntryLockException extends PortalException {

	public FileEntryLockException() {
	}

	public FileEntryLockException(String msg) {
		super(msg);
	}

	public FileEntryLockException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FileEntryLockException(Throwable cause) {
		super(cause);
	}

	public static class MustBeUnlocked extends FileEntryLockException {
	}

	public static class MustOwnLock extends FileEntryLockException {
	}

}