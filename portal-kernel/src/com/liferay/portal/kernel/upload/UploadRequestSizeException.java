/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upload;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Roberto Díaz
 */
public class UploadRequestSizeException extends PortalException {

	public UploadRequestSizeException() {
	}

	public UploadRequestSizeException(String msg) {
		super(msg);
	}

	public UploadRequestSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UploadRequestSizeException(Throwable cause) {
		super(cause);
	}

}