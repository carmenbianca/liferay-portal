/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRepositoryEntryException extends NoSuchModelException {

	public NoSuchRepositoryEntryException() {
	}

	public NoSuchRepositoryEntryException(String msg) {
		super(msg);
	}

	public NoSuchRepositoryEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRepositoryEntryException(Throwable cause) {
		super(cause);
	}

}