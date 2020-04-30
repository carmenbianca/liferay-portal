/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.service.impl;

import com.liferay.polls.service.base.PollsChoiceServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=polls",
		"json.web.service.context.path=PollsChoice"
	},
	service = AopService.class
)
public class PollsChoiceServiceImpl extends PollsChoiceServiceBaseImpl {
}