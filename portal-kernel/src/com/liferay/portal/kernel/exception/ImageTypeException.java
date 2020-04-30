/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageTypeException extends PortalException {

	public ImageTypeException() {
	}

	public ImageTypeException(String msg) {
		super(msg);
	}

	public ImageTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ImageTypeException(Throwable cause) {
		super(cause);
	}

}