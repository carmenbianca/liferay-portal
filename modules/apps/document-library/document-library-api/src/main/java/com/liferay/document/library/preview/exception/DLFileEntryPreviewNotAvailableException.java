/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.preview.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alejandro Tardín
 */
public class DLFileEntryPreviewNotAvailableException extends PortalException {

	public DLFileEntryPreviewNotAvailableException() {
	}

	public DLFileEntryPreviewNotAvailableException(String msg) {
		super(msg);
	}

	public DLFileEntryPreviewNotAvailableException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DLFileEntryPreviewNotAvailableException(Throwable cause) {
		super(cause);
	}

}