/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Douglas Wong
 */
public class FileExtensionException extends PortalException {

	public FileExtensionException() {
	}

	public FileExtensionException(String msg) {
		super(msg);
	}

	public FileExtensionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FileExtensionException(Throwable cause) {
		super(cause);
	}

}