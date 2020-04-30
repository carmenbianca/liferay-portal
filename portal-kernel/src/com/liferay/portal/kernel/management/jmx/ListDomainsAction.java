/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.management.jmx;

import javax.management.MBeanServer;

/**
 * @author Shuyang Zhou
 */
public class ListDomainsAction extends BaseJMXManageAction<String[]> {

	@Override
	public String[] action() {
		MBeanServer mBeanServer = getMBeanServer();

		return mBeanServer.getDomains();
	}

}