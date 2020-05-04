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
public interface Event {

	public List<QName> getAliasQNames();

	public QName getQName();

	public String getValueType();

}