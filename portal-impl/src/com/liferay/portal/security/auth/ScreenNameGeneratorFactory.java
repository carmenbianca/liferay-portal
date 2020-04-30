/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.security.auth.ScreenNameGenerator;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceTracker;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 * @author Peter Fellwock
 */
public class ScreenNameGeneratorFactory {

	public static ScreenNameGenerator getInstance() {
		return _screenNameGeneratorFactory._serviceTracker.getService();
	}

	private ScreenNameGeneratorFactory() {
		Registry registry = RegistryUtil.getRegistry();

		_serviceTracker = registry.trackServices(ScreenNameGenerator.class);

		_serviceTracker.open();
	}

	private static final ScreenNameGeneratorFactory
		_screenNameGeneratorFactory = new ScreenNameGeneratorFactory();

	private final ServiceTracker<?, ScreenNameGenerator> _serviceTracker;

}