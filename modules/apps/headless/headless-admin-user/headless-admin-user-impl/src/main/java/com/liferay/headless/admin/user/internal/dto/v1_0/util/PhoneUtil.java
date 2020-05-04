/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.admin.user.internal.dto.v1_0.util;

import com.liferay.headless.admin.user.dto.v1_0.Phone;
import com.liferay.portal.kernel.model.ListType;

/**
 * @author Javier Gamarra
 */
public class PhoneUtil {

	public static Phone toPhone(com.liferay.portal.kernel.model.Phone phone)
		throws Exception {

		ListType listType = phone.getType();

		return new Phone() {
			{
				extension = phone.getExtension();
				id = phone.getPhoneId();
				phoneNumber = phone.getNumber();
				phoneType = listType.getName();
				primary = phone.isPrimary();
			}
		};
	}

}