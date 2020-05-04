/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal.scope;

import java.lang.annotation.Annotation;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;

import javax.portlet.PortletSession;
import javax.portlet.annotations.PortletSessionScoped;

/**
 * @author Neil Griffin
 */
public class PortletSessionBeanContext extends BaseContextImpl {

	@Override
	public <T> T get(
		Contextual<T> contextual, CreationalContext<T> creationalContext) {

		ScopedBeanManager scopedBeanManager =
			ScopedBeanManagerThreadLocal.getCurrentScopedBeanManager();

		Bean<T> bean = (Bean<T>)contextual;

		Class<?> beanClass = bean.getBeanClass();

		int scope = PortletSession.PORTLET_SCOPE;

		PortletSessionScoped portletSessionScoped = beanClass.getAnnotation(
			PortletSessionScoped.class);

		if (portletSessionScoped != null) {
			scope = portletSessionScoped.value();
		}

		return scopedBeanManager.getPortletSessionScopedBean(
			scope, bean, creationalContext);
	}

	@Override
	public Class<? extends Annotation> getScope() {
		return PortletSessionScoped.class;
	}

}