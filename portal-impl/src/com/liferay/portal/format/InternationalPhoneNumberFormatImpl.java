/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.format;

import com.liferay.portal.kernel.format.PhoneNumberFormat;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsValues;

/**
 * @author Brian Wing Shun Chan
 * @author Manuel de la Peña
 */
public class InternationalPhoneNumberFormatImpl implements PhoneNumberFormat {

	@Override
	public String format(String phoneNumber) {
		return phoneNumber;
	}

	@Override
	public String strip(String phoneNumber) {
		return phoneNumber;
	}

	@Override
	public boolean validate(String phoneNumber) {
		if (Validator.isNull(phoneNumber)) {
			return false;
		}

		return phoneNumber.matches(
			PropsValues.PHONE_NUMBER_FORMAT_INTERNATIONAL_REGEXP);
	}

}