/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.service.impl;

import com.liferay.dispatch.service.base.DispatchLogLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	property = "model.class.name=com.liferay.dispatch.model.DispatchLog",
	service = AopService.class
)
public class DispatchLogLocalServiceImpl
	extends DispatchLogLocalServiceBaseImpl {
}