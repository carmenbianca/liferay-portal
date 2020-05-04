/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xmlrpc;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.xmlrpc.Success;
import com.liferay.portal.kernel.xmlrpc.XmlRpcException;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public class SuccessImpl implements Success {

	public SuccessImpl(String description) {
		_description = description;
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public String toString() {
		return "XML-RPC success " + _description;
	}

	@Override
	public String toXml() throws XmlRpcException {
		StringBundler sb = new StringBundler(8);

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		sb.append("<methodResponse>");
		sb.append("<params>");
		sb.append("<param>");
		sb.append(XmlRpcParser.wrapValue(_description));
		sb.append("</param>");
		sb.append("</params>");
		sb.append("</methodResponse>");

		return sb.toString();
	}

	private final String _description;

}