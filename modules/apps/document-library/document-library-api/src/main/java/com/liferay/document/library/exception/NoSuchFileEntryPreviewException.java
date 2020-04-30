/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFileEntryPreviewException extends NoSuchModelException {

	public NoSuchFileEntryPreviewException() {
	}

	public NoSuchFileEntryPreviewException(String msg) {
		super(msg);
	}

	public NoSuchFileEntryPreviewException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFileEntryPreviewException(Throwable cause) {
		super(cause);
	}

}