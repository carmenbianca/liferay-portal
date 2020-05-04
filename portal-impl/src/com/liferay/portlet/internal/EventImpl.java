/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import java.io.Serializable;

import javax.portlet.Event;

import javax.xml.namespace.QName;

/**
 * @author Brian Wing Shun Chan
 */
public class EventImpl implements Event, Serializable {

	public EventImpl(String name, QName qName, Serializable value) {
		_name = name;
		_qName = qName;
		_value = value;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public QName getQName() {
		return _qName;
	}

	@Override
	public Serializable getValue() {
		return _value;
	}

	private final String _name;
	private final QName _qName;
	private final Serializable _value;

}