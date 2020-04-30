/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSyncException extends NoSuchModelException {

	public NoSuchSyncException() {
	}

	public NoSuchSyncException(String msg) {
		super(msg);
	}

	public NoSuchSyncException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSyncException(Throwable cause) {
		super(cause);
	}

}