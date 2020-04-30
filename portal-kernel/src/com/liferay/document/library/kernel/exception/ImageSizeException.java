/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageSizeException extends PortalException {

	public ImageSizeException() {
	}

	public ImageSizeException(String msg) {
		super(msg);
	}

	public ImageSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ImageSizeException(Throwable cause) {
		super(cause);
	}

}