/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.jaas;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalRole extends PortalPrincipal {

	public PortalRole() {
	}

	public PortalRole(String name) {
		super(name);
	}

}