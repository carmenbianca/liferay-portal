/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.extension;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Neil Griffin
 */
@FunctionalInterface
@ProviderType
public interface BeanFilterMethodInvoker {

	public void invokeWithActiveScopes(
			BeanFilterMethod beanFilterMethod, Object filterChain,
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws PortletException;

}