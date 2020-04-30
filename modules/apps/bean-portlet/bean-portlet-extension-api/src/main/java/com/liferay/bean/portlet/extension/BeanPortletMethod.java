/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.extension;

import java.lang.reflect.Method;

import javax.portlet.PortletMode;

import javax.xml.namespace.QName;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Neil Griffin
 */
@ProviderType
public interface BeanPortletMethod extends Comparable<BeanPortletMethod> {

	public String getActionName();

	public BeanPortletMethodType getBeanPortletMethodType();

	public Class<?> getBeanType();

	public Method getMethod();

	public int getOrdinal();

	public PortletMode getPortletMode();

	public String getResourceID();

	public Object invoke(Object... arguments)
		throws ReflectiveOperationException;

	public boolean isEventProcessor(QName qName);

}