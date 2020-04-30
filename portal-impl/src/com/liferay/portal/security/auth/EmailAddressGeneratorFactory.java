/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.security.auth.EmailAddressGenerator;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceTracker;

/**
 * @author Amos Fong
 * @author Shuyang Zhou
 * @author Peter Fellwock
 */
public class EmailAddressGeneratorFactory {

	public static EmailAddressGenerator getInstance() {
		return _emailAddressGeneratorFactory._serviceTracker.getService();
	}

	private EmailAddressGeneratorFactory() {
		Registry registry = RegistryUtil.getRegistry();

		_serviceTracker = registry.trackServices(EmailAddressGenerator.class);

		_serviceTracker.open();
	}

	private static final EmailAddressGeneratorFactory
		_emailAddressGeneratorFactory = new EmailAddressGeneratorFactory();

	private final ServiceTracker<?, EmailAddressGenerator> _serviceTracker;

}