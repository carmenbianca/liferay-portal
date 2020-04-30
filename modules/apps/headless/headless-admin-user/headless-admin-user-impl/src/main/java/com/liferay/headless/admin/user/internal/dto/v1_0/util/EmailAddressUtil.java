/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.admin.user.internal.dto.v1_0.util;

import com.liferay.headless.admin.user.dto.v1_0.EmailAddress;
import com.liferay.portal.kernel.model.ListType;

/**
 * @author Javier Gamarra
 */
public class EmailAddressUtil {

	public static EmailAddress toEmailAddress(
			com.liferay.portal.kernel.model.EmailAddress
				serviceBuilderEmailAddress)
		throws Exception {

		ListType listType = serviceBuilderEmailAddress.getType();

		return new EmailAddress() {
			{
				emailAddress = serviceBuilderEmailAddress.getAddress();
				id = serviceBuilderEmailAddress.getEmailAddressId();
				primary = serviceBuilderEmailAddress.isPrimary();
				type = listType.getName();
			}
		};
	}

}