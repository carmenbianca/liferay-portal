/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.format;

import com.liferay.portal.kernel.format.PhoneNumberFormat;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Brian Wing Shun Chan
 * @author Manuel de la Peña
 */
public abstract class BasePhoneNumberFormatImplTestCase {

	@Test
	public void testInvalidPhoneNumbers() {
		PhoneNumberFormat phoneNumberFormat = getPhoneNumberFormat();

		String[] phoneNumbers = getInvalidPhoneNumbers();

		for (String phoneNumber : phoneNumbers) {
			Assert.assertFalse(
				phoneNumber, phoneNumberFormat.validate(phoneNumber));
		}
	}

	@Test
	public void testValidPhoneNumbers() {
		PhoneNumberFormat phoneNumberFormat = getPhoneNumberFormat();

		String[] phoneNumbers = getValidPhoneNumbers();

		for (String phoneNumber : phoneNumbers) {
			Assert.assertTrue(
				phoneNumber, phoneNumberFormat.validate(phoneNumber));
		}
	}

	protected abstract String[] getInvalidPhoneNumbers();

	protected abstract PhoneNumberFormat getPhoneNumberFormat();

	protected abstract String[] getValidPhoneNumbers();

}