/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class LARFileSizeException extends PortalException {

	public LARFileSizeException() {
	}

	public LARFileSizeException(String msg) {
		super(msg);
	}

	public LARFileSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LARFileSizeException(Throwable cause) {
		super(cause);
	}

}