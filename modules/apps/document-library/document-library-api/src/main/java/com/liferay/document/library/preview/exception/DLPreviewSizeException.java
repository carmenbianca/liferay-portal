/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.preview.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alejandro Tardín
 */
public class DLPreviewSizeException extends PortalException {

	public DLPreviewSizeException() {
	}

	public DLPreviewSizeException(String msg) {
		super(msg);
	}

	public DLPreviewSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DLPreviewSizeException(Throwable cause) {
		super(cause);
	}

}