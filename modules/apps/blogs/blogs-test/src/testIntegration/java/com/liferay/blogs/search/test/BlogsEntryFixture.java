/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.search.test;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowThreadLocal;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Igor Fabiano Nazar
 * @author Luan Maoski
 */
public class BlogsEntryFixture {

	public BlogsEntryFixture(
		BlogsEntryLocalService blogsEntryLocalService, Group group) {

		_blogsEntryLocalService = blogsEntryLocalService;
		_group = group;
	}

	public BlogsEntry createBlogsEntry(String title) throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), getUserId());

		BlogsEntry blogsEntry = addEntryWithWorkflow(
			getUserId(), title, true, serviceContext);

		_blogsEntries.add(blogsEntry);

		return blogsEntry;
	}

	public List<BlogsEntry> getBlogsEntries() {
		return _blogsEntries;
	}

	public void updateDisplaySettings(Locale locale) throws Exception {
		Group group = GroupTestUtil.updateDisplaySettings(
			_group.getGroupId(), null, locale);

		_group.setModelAttributes(group.getModelAttributes());
	}

	protected BlogsEntry addEntryWithWorkflow(
			long userId, String title, boolean approved,
			ServiceContext serviceContext)
		throws Exception {

		boolean workflowEnabled = WorkflowThreadLocal.isEnabled();

		try {
			WorkflowThreadLocal.setEnabled(true);

			Calendar displayCalendar = CalendarFactoryUtil.getCalendar(
				2012, 1, 1);

			serviceContext.setWorkflowAction(
				WorkflowConstants.ACTION_SAVE_DRAFT);

			BlogsEntry entry = _blogsEntryLocalService.addEntry(
				userId, title, RandomTestUtil.randomString(),
				RandomTestUtil.randomString(), RandomTestUtil.randomString(),
				displayCalendar.getTime(), true, true, new String[0],
				StringPool.BLANK, null, null, serviceContext);

			if (approved) {
				return _blogsEntryLocalService.updateStatus(
					entry.getUserId(), entry.getEntryId(),
					WorkflowConstants.STATUS_APPROVED, serviceContext,
					getWorkflowContextMap());
			}

			return entry;
		}
		finally {
			WorkflowThreadLocal.setEnabled(workflowEnabled);
		}
	}

	protected long getUserId() throws Exception {
		return TestPropsValues.getUserId();
	}

	protected Map<String, Serializable> getWorkflowContextMap() {
		return HashMapBuilder.<String, Serializable>put(
			WorkflowConstants.CONTEXT_URL, "http://localhost"
		).put(
			WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, "http://localhost"
		).put(
			WorkflowConstants.CONTEXT_USER_URL, "http://localhost"
		).build();
	}

	private final List<BlogsEntry> _blogsEntries = new ArrayList<>();
	private final BlogsEntryLocalService _blogsEntryLocalService;
	private final Group _group;

}