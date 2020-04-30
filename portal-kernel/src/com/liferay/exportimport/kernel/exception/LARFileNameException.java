/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eric Min
 */
public class LARFileNameException extends PortalException {

	public LARFileNameException() {
	}

	public LARFileNameException(String msg) {
		super(msg);
	}

	public LARFileNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LARFileNameException(Throwable cause) {
		super(cause);
	}

}