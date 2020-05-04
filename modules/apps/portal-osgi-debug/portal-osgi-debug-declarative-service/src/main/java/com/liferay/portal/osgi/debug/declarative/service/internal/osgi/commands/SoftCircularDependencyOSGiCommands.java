/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.debug.declarative.service.internal.osgi.commands;

import com.liferay.portal.osgi.debug.declarative.service.internal.SoftCircularDependencyUtil;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.runtime.ServiceComponentRuntime;

/**
 * @author Shuyang Zhou
 */
@Component(
	immediate = true,
	property = {
		"osgi.command.function=softCircularDependency", "osgi.command.scope=ds"
	},
	service = SoftCircularDependencyOSGiCommands.class
)
public class SoftCircularDependencyOSGiCommands {

	public void softCircularDependency() {
		System.out.println(
			SoftCircularDependencyUtil.listSoftCircularDependencies(
				_serviceComponentRuntime, _bundleContext));
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;
	}

	private BundleContext _bundleContext;

	@Reference
	private ServiceComponentRuntime _serviceComponentRuntime;

}