/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xmlrpc;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public interface XmlRpc {

	public Fault createFault(int code, String description);

	public Success createSuccess(String description);

	public Response executeMethod(
			String url, String methodName, Object[] arguments)
		throws XmlRpcException;

}