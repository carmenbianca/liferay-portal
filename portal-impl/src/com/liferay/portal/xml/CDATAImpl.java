/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xml;

import com.liferay.portal.kernel.xml.CDATA;
import com.liferay.portal.kernel.xml.Visitor;

/**
 * @author Brian Wing Shun Chan
 */
public class CDATAImpl extends NodeImpl implements CDATA {

	public CDATAImpl(org.dom4j.CDATA cdata) {
		super(cdata);

		_cdata = cdata;
	}

	@Override
	public <T, V extends Visitor<T>> T accept(V visitor) {
		return visitor.visitCDATA(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CDATAImpl)) {
			return false;
		}

		CDATAImpl cdataImpl = (CDATAImpl)obj;

		org.dom4j.CDATA cdata = cdataImpl.getWrappedCDATA();

		return _cdata.equals(cdata);
	}

	public org.dom4j.CDATA getWrappedCDATA() {
		return _cdata;
	}

	@Override
	public int hashCode() {
		return _cdata.hashCode();
	}

	@Override
	public String toString() {
		return _cdata.toString();
	}

	private final org.dom4j.CDATA _cdata;

}