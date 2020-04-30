/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.management.jmx;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.management.ManageAction;

import java.util.concurrent.atomic.AtomicReference;

import javax.management.MBeanServer;

/**
 * @author Shuyang Zhou
 */
public abstract class BaseJMXManageAction<T> implements ManageAction<T> {

	protected MBeanServer getMBeanServer() {
		MBeanServer mBeanServer = _mBeanServerReference.get();

		if (mBeanServer == null) {
			mBeanServer = (MBeanServer)PortalBeanLocatorUtil.locate(
				"mBeanServer");

			_mBeanServerReference.compareAndSet(null, mBeanServer);
		}

		return mBeanServer;
	}

	private static final AtomicReference<MBeanServer> _mBeanServerReference =
		new AtomicReference<>();

}