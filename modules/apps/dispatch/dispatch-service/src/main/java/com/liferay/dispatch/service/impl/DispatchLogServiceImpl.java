/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.service.impl;

import com.liferay.dispatch.service.base.DispatchLogServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	property = {
		"json.web.service.context.name=dispatch",
		"json.web.service.context.path=DispatchLog"
	},
	service = AopService.class
)
public class DispatchLogServiceImpl extends DispatchLogServiceBaseImpl {
}