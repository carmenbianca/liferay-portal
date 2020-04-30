/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.format;

import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceTracker;

/**
 * @author Brian Wing Shun Chan
 * @author Manuel de la Peña
 * @author Peter Fellwock
 */
public class PhoneNumberFormatUtil {

	public static String format(String phoneNumber) {
		return getPhoneNumberFormat().format(phoneNumber);
	}

	public static PhoneNumberFormat getPhoneNumberFormat() {
		return _phoneNumberFormatUtil._serviceTracker.getService();
	}

	public static String strip(String phoneNumber) {
		return getPhoneNumberFormat().strip(phoneNumber);
	}

	public static boolean validate(String phoneNumber) {
		return getPhoneNumberFormat().validate(phoneNumber);
	}

	private PhoneNumberFormatUtil() {
		Registry registry = RegistryUtil.getRegistry();

		_serviceTracker = registry.trackServices(PhoneNumberFormat.class);

		_serviceTracker.open();
	}

	private static final PhoneNumberFormatUtil _phoneNumberFormatUtil =
		new PhoneNumberFormatUtil();

	private final ServiceTracker<PhoneNumberFormat, PhoneNumberFormat>
		_serviceTracker;

}