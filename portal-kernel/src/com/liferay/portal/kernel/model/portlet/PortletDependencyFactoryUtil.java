/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model.portlet;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

import javax.portlet.PortletRequest;

/**
 * @author Neil Griffin
 */
public class PortletDependencyFactoryUtil {

	public static PortletDependency createPortletDependency(
		String name, String scope, String version) {

		return _portletDependencyFactory.createPortletDependency(
			name, scope, version);
	}

	public static PortletDependency createPortletDependency(
		String name, String scope, String version, String markup,
		PortletRequest portletRequest) {

		return _portletDependencyFactory.createPortletDependency(
			name, scope, version, markup, portletRequest);
	}

	private static volatile PortletDependencyFactory _portletDependencyFactory =
		ServiceProxyFactory.newServiceTrackedInstance(
			PortletDependencyFactory.class, PortletDependencyFactoryUtil.class,
			"_portletDependencyFactory", false);

}