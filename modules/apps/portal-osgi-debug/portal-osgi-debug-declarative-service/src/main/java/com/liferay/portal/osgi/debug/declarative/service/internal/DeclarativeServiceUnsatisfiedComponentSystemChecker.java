/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.debug.declarative.service.internal;

import com.liferay.portal.osgi.debug.SystemChecker;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.runtime.ServiceComponentRuntime;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = SystemChecker.class)
public class DeclarativeServiceUnsatisfiedComponentSystemChecker
	implements SystemChecker {

	@Override
	public String check() {
		return UnsatisfiedComponentUtil.listUnsatisfiedComponents(
			_serviceComponentRuntime, _bundleContext.getBundles());
	}

	@Override
	public String getName() {
		return "Declarative Service Unsatisfied Component Checker";
	}

	@Override
	public String getOSGiCommand() {
		return "ds:unsatisfied";
	}

	@Override
	public String toString() {
		return getName();
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;
	}

	private BundleContext _bundleContext;

	@Reference
	private ServiceComponentRuntime _serviceComponentRuntime;

}