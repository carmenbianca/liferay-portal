/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.format;

import com.liferay.portal.kernel.format.PhoneNumberFormat;

/**
 * @author Brian Wing Shun Chan
 * @author Manuel de la Peña
 */
public class InternationalPhoneNumberFormatImplTest
	extends BasePhoneNumberFormatImplTestCase {

	@Override
	public String[] getInvalidPhoneNumbers() {
		return new String[0];
	}

	@Override
	public PhoneNumberFormat getPhoneNumberFormat() {
		return new InternationalPhoneNumberFormatImpl();
	}

	@Override
	public String[] getValidPhoneNumbers() {
		/*return new String[] {
			"+34 91 733 63 43", "+55 81 3033 1405", "+49 (0) 6196 773 0680",
			"+36 (1) 786 4575", "+86 (0411) 8812-0855", "1-123-456-7890",
			"1.123.456.7890"
		};*/

		return new String[0];
	}

}