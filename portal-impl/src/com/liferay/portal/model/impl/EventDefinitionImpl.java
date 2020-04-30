/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.model.EventDefinition;
import com.liferay.portal.kernel.model.PortletApp;
import com.liferay.portal.kernel.xml.QName;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 */
public class EventDefinitionImpl implements EventDefinition {

	public EventDefinitionImpl(
		QName qName, String valueType, PortletApp portletApp) {

		_qName = qName;
		_valueType = valueType;
		_portletApp = portletApp;

		_qNames = new HashSet<>();

		_qNames.add(_qName);
	}

	@Override
	public void addAliasQName(QName aliasQName) {
		_qNames.add(aliasQName);
	}

	@Override
	public PortletApp getPortletApp() {
		return _portletApp;
	}

	@Override
	public QName getQName() {
		return _qName;
	}

	@Override
	public Set<QName> getQNames() {
		return _qNames;
	}

	@Override
	public String getValueType() {
		return _valueType;
	}

	@Override
	public void setPortletApp(PortletApp portletApp) {
		_portletApp = portletApp;
	}

	@Override
	public void setQName(QName qName) {
		_qName = qName;
	}

	@Override
	public void setValueType(String valueType) {
		_valueType = valueType;
	}

	private PortletApp _portletApp;
	private QName _qName;
	private final Set<QName> _qNames;
	private String _valueType;

}