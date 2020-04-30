/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission.resource.definition;

import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;

/**
 * @author Preston Crary
 */
public interface PortletResourcePermissionDefinition {

	public PortletResourcePermissionLogic[]
		getPortletResourcePermissionLogics();

	public String getResourceName();

}