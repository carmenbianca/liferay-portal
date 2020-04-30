/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.format;

/**
 * @author Brian Wing Shun Chan
 * @author Manuel de la Peña
 */
public class PhoneNumberFormatWrapper implements PhoneNumberFormat {

	public PhoneNumberFormatWrapper(PhoneNumberFormat phoneNumberFormat) {
		_originalPhoneNumberFormat = phoneNumberFormat;
		_phoneNumberFormat = phoneNumberFormat;
	}

	@Override
	public String format(String phoneNumber) {
		return _phoneNumberFormat.format(phoneNumber);
	}

	public void setPhoneNumberFormat(PhoneNumberFormat phoneNumberFormat) {
		if (phoneNumberFormat == null) {
			_phoneNumberFormat = _originalPhoneNumberFormat;
		}
		else {
			_phoneNumberFormat = phoneNumberFormat;
		}
	}

	@Override
	public String strip(String phoneNumber) {
		return _phoneNumberFormat.strip(phoneNumber);
	}

	@Override
	public boolean validate(String phoneNumber) {
		return _phoneNumberFormat.validate(phoneNumber);
	}

	private final PhoneNumberFormat _originalPhoneNumberFormat;
	private PhoneNumberFormat _phoneNumberFormat;

}