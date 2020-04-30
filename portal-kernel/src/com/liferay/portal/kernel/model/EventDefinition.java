/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.xml.QName;

import java.io.Serializable;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 */
public interface EventDefinition extends Serializable {

	public void addAliasQName(QName aliasQName);

	public PortletApp getPortletApp();

	public QName getQName();

	public Set<QName> getQNames();

	public String getValueType();

	public void setPortletApp(PortletApp portletApp);

	public void setQName(QName qName);

	public void setValueType(String valueType);

}