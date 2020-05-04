/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.init.servlet.filter.internal;

import com.liferay.portal.kernel.dependency.manager.DependencyManagerSyncUtil;
import com.liferay.portal.servlet.filters.BasePortalFilter;

import java.util.concurrent.CountDownLatch;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.ServiceRegistration;

/**
 * @author Matthew Tambara
 */
public class InitFilter extends BasePortalFilter {

	public void setServiceRegistration(
		ServiceRegistration<Filter> serviceRegistration) {

		_serviceRegistration = serviceRegistration;

		_countDownLatch.countDown();
	}

	@Override
	protected void processFilter(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, FilterChain filterChain)
		throws Exception {

		_countDownLatch.await();

		synchronized (this) {
			DependencyManagerSyncUtil.sync();

			try {
				processFilter(
					InitFilter.class.getName(), httpServletRequest,
					httpServletResponse, filterChain);
			}
			finally {
				if (_serviceRegistration != null) {
					_serviceRegistration.unregister();

					_serviceRegistration = null;
				}
			}
		}
	}

	private final CountDownLatch _countDownLatch = new CountDownLatch(1);
	private ServiceRegistration<Filter> _serviceRegistration;

}