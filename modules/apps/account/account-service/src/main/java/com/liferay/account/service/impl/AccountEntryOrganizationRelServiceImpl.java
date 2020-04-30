/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.service.impl;

import com.liferay.account.service.base.AccountEntryOrganizationRelServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=account",
		"json.web.service.context.path=AccountEntryOrganizationRel"
	},
	service = AopService.class
)
public class AccountEntryOrganizationRelServiceImpl
	extends AccountEntryOrganizationRelServiceBaseImpl {
}