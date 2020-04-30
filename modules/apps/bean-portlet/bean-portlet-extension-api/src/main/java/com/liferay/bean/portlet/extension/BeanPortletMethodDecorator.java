/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.extension;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Neil Griffin
 */
@ProviderType
public interface BeanPortletMethodDecorator {

	public BeanPortletMethod getBeanMethod(
		BeanPortletMethod beanPortletMethod, PortletConfig portletConfig,
		PortletRequest portletRequest, PortletResponse portletResponse);

}