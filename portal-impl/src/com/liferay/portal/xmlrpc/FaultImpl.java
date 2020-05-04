/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xmlrpc;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.xmlrpc.Fault;
import com.liferay.portal.kernel.xmlrpc.XmlRpcException;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public class FaultImpl implements Fault {

	public FaultImpl(int code, String description) {
		_code = code;
		_description = description;
	}

	@Override
	public int getCode() {
		return _code;
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public String toString() {
		return StringBundler.concat("XML-RPC fault ", _code, " ", _description);
	}

	@Override
	public String toXml() throws XmlRpcException {
		StringBundler sb = new StringBundler(17);

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		sb.append("<methodResponse>");
		sb.append("<fault>");
		sb.append("<value>");
		sb.append("<struct>");
		sb.append("<member>");
		sb.append("<name>faultCode</name>");
		sb.append(XmlRpcParser.wrapValue(_code));
		sb.append("</member>");
		sb.append("<member>");
		sb.append("<name>faultString</name>");
		sb.append(XmlRpcParser.wrapValue(_description));
		sb.append("</member>");
		sb.append("</struct>");
		sb.append("</value>");
		sb.append("</fault>");
		sb.append("</methodResponse>");

		return sb.toString();
	}

	private final int _code;
	private final String _description;

}