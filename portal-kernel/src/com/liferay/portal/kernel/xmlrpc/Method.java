/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xmlrpc;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public interface Method {

	public Response execute(long companyId) throws XmlRpcException;

	public String getMethodName();

	public String getToken();

	public boolean setArguments(Object[] arguments);

}