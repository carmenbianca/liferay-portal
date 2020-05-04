/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal;

import java.util.List;

import javax.xml.namespace.QName;

/**
 * @author Neil Griffin
 */
public class EventImpl implements Event {

	public EventImpl(QName qName, String valueType, List<QName> aliasQNames) {
		_qName = qName;
		_valueType = valueType;
		_aliasQNames = aliasQNames;
	}

	@Override
	public List<QName> getAliasQNames() {
		return _aliasQNames;
	}

	@Override
	public QName getQName() {
		return _qName;
	}

	@Override
	public String getValueType() {
		return _valueType;
	}

	private final List<QName> _aliasQNames;
	private final QName _qName;
	private final String _valueType;

}