/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.security.auth.EmailAddressValidator;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceTracker;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 * @author Peter Fellwock
 */
public class EmailAddressValidatorFactory {

	public static EmailAddressValidator getInstance() {
		return _emailAddressValidatorFactory._serviceTracker.getService();
	}

	private EmailAddressValidatorFactory() {
		Registry registry = RegistryUtil.getRegistry();

		_serviceTracker = registry.trackServices(EmailAddressValidator.class);

		_serviceTracker.open();
	}

	private static final EmailAddressValidatorFactory
		_emailAddressValidatorFactory = new EmailAddressValidatorFactory();

	private final ServiceTracker<?, EmailAddressValidator> _serviceTracker;

}