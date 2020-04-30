/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.jaas;

import com.liferay.portal.kernel.servlet.ProtectedPrincipal;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalPrincipal extends ProtectedPrincipal {

	public PortalPrincipal() {
	}

	public PortalPrincipal(String name) {
		super(name);
	}

}