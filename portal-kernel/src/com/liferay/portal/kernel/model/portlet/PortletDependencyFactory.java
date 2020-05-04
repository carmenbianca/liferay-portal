/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model.portlet;

import javax.portlet.PortletRequest;

/**
 * @author Neil Griffin
 */
public interface PortletDependencyFactory {

	public PortletDependency createPortletDependency(
		String name, String scope, String version);

	public PortletDependency createPortletDependency(
		String name, String scope, String version, String markup,
		PortletRequest portletRequest);

}