/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.preview.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Roberto Díaz
 */
public class DLFileEntryPreviewGenerationException extends PortalException {

	public DLFileEntryPreviewGenerationException() {
	}

	public DLFileEntryPreviewGenerationException(String msg) {
		super(msg);
	}

	public DLFileEntryPreviewGenerationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DLFileEntryPreviewGenerationException(Throwable cause) {
		super(cause);
	}

}