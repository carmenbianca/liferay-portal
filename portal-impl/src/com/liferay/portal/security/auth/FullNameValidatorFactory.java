/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.security.auth.FullNameValidator;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceTracker;

/**
 * @author Amos Fong
 * @author Shuyang Zhou
 * @author Peter Fellwock
 */
public class FullNameValidatorFactory {

	public static FullNameValidator getInstance() {
		return _fullNameValidatorFactory._serviceTracker.getService();
	}

	private FullNameValidatorFactory() {
		Registry registry = RegistryUtil.getRegistry();

		_serviceTracker = registry.trackServices(FullNameValidator.class);

		_serviceTracker.open();
	}

	private static final FullNameValidatorFactory _fullNameValidatorFactory =
		new FullNameValidatorFactory();

	private final ServiceTracker<FullNameValidator, FullNameValidator>
		_serviceTracker;

}