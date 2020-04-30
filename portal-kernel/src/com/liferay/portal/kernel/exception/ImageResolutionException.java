/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageResolutionException extends PortalException {

	public ImageResolutionException() {
	}

	public ImageResolutionException(String msg) {
		super(msg);
	}

	public ImageResolutionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ImageResolutionException(Throwable cause) {
		super(cause);
	}

}