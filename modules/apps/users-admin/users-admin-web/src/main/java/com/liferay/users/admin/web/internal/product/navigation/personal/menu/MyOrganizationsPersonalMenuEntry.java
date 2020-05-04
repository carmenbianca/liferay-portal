/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.product.navigation.personal.menu;

import com.liferay.product.navigation.personal.menu.BasePersonalMenuEntry;
import com.liferay.product.navigation.personal.menu.PersonalMenuEntry;
import com.liferay.users.admin.constants.UsersAdminPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pei-Jung Lan
 */
@Component(
	immediate = true,
	property = {
		"product.navigation.personal.menu.entry.order:Integer=300",
		"product.navigation.personal.menu.group:Integer=300"
	},
	service = PersonalMenuEntry.class
)
public class MyOrganizationsPersonalMenuEntry extends BasePersonalMenuEntry {

	@Override
	public String getPortletId() {
		return UsersAdminPortletKeys.MY_ORGANIZATIONS;
	}

}