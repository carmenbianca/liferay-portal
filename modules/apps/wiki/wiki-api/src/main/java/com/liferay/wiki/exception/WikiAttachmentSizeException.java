/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Roberto Díaz
 */
public class WikiAttachmentSizeException extends PortalException {

	public WikiAttachmentSizeException() {
	}

	public WikiAttachmentSizeException(String msg) {
		super(msg);
	}

	public WikiAttachmentSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WikiAttachmentSizeException(Throwable cause) {
		super(cause);
	}

}