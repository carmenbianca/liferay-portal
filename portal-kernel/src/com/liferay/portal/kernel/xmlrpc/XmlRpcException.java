/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xmlrpc;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alexander Chow
 */
public class XmlRpcException extends PortalException {

	public XmlRpcException() {
	}

	public XmlRpcException(String msg) {
		super(msg);
	}

	public XmlRpcException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public XmlRpcException(Throwable cause) {
		super(cause);
	}

}