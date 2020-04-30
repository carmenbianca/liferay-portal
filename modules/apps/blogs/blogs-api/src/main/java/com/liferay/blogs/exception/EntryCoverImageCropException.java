/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryCoverImageCropException extends PortalException {

	public EntryCoverImageCropException() {
	}

	public EntryCoverImageCropException(String msg) {
		super(msg);
	}

	public EntryCoverImageCropException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryCoverImageCropException(Throwable cause) {
		super(cause);
	}

}