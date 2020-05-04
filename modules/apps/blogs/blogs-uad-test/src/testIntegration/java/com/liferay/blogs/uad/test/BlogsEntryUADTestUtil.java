/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.uad.test;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @author William Newbury
 */
public class BlogsEntryUADTestUtil {

	public static BlogsEntry addBlogsEntry(
			BlogsEntryLocalService blogsEntryLocalService, long userId)
		throws Exception {

		Calendar calendar = CalendarFactoryUtil.getCalendar();

		calendar.add(Calendar.DATE, 1);

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getGroupId());

		return blogsEntryLocalService.addEntry(
			userId, RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), calendar.getTime(), serviceContext);
	}

	public static BlogsEntry addBlogsEntryWithStatusByUserId(
			BlogsEntryLocalService blogsEntryLocalService, long userId,
			long statusByUserId)
		throws Exception {

		BlogsEntry blogsEntry = addBlogsEntry(blogsEntryLocalService, userId);

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				TestPropsValues.getGroupId());

		return blogsEntryLocalService.updateStatus(
			statusByUserId, blogsEntry.getEntryId(),
			WorkflowConstants.STATUS_APPROVED, serviceContext,
			new HashMap<String, Serializable>());
	}

}