/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.html.preview.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchHtmlPreviewEntryException extends NoSuchModelException {

	public NoSuchHtmlPreviewEntryException() {
	}

	public NoSuchHtmlPreviewEntryException(String msg) {
		super(msg);
	}

	public NoSuchHtmlPreviewEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchHtmlPreviewEntryException(Throwable cause) {
		super(cause);
	}

}