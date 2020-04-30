/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.preview.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alejandro Tardín
 */
public class DLPreviewGenerationInProcessException extends PortalException {

	public DLPreviewGenerationInProcessException() {
	}

	public DLPreviewGenerationInProcessException(String msg) {
		super(msg);
	}

	public DLPreviewGenerationInProcessException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DLPreviewGenerationInProcessException(Throwable cause) {
		super(cause);
	}

}