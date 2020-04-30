/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xmlrpc;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public interface Response {

	public String getDescription();

	public String toXml() throws XmlRpcException;

}