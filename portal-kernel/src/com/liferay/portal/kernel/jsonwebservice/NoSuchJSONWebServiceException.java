/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.jsonwebservice;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Igor Spasic
 */
public class NoSuchJSONWebServiceException extends PortalException {

	public NoSuchJSONWebServiceException() {
	}

	public NoSuchJSONWebServiceException(String msg) {
		super(msg);
	}

	public NoSuchJSONWebServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchJSONWebServiceException(Throwable cause) {
		super(cause);
	}

}