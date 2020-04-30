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
public abstract class BeanPortletMethodWrapper implements BeanPortletMethod {

	public BeanPortletMethodWrapper(BeanPortletMethod beanPortletMethod) {
		_beanPortletMethod = beanPortletMethod;
	}

	@Override
	public int compareTo(BeanPortletMethod beanPortletMethod) {
		return _beanPortletMethod.compareTo(beanPortletMethod);
	}

	@Override
	public String getActionName() {
		return _beanPortletMethod.getActionName();
	}

	@Override
	public BeanPortletMethodType getBeanPortletMethodType() {
		return _beanPortletMethod.getBeanPortletMethodType();
	}

	@Override
	public Class<?> getBeanType() {
		return _beanPortletMethod.getBeanType();
	}

	@Override
	public Method getMethod() {
		return _beanPortletMethod.getMethod();
	}

	@Override
	public int getOrdinal() {
		return _beanPortletMethod.getOrdinal();
	}

	@Override
	public PortletMode getPortletMode() {
		return _beanPortletMethod.getPortletMode();
	}

	@Override
	public String getResourceID() {
		return _beanPortletMethod.getResourceID();
	}

	public BeanPortletMethod getWrapped() {
		return _beanPortletMethod;
	}

	@Override
	public Object invoke(Object... arguments)
		throws ReflectiveOperationException {

		return _beanPortletMethod.invoke(arguments);
	}

	@Override
	public boolean isEventProcessor(QName qName) {
		return _beanPortletMethod.isEventProcessor(qName);
	}

	private final BeanPortletMethod _beanPortletMethod;

}