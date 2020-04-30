/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.reading.time.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.reading.time.service.base.ReadingTimeEntryServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=readingtime",
		"json.web.service.context.path=ReadingTimeEntry"
	},
	service = AopService.class
)
public class ReadingTimeEntryServiceImpl
	extends ReadingTimeEntryServiceBaseImpl {
}