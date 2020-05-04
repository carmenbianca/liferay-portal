/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.test.blogs.util;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalService;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André de Oliveira
 */
public class BlogsEntrySearchFixture {

	public BlogsEntrySearchFixture(
		BlogsEntryLocalService blogsEntryLocalService) {

		_blogsEntryLocalService = blogsEntryLocalService;
	}

	public BlogsEntry addBlogsEntry(Group group, User user, String keyword)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(group.getGroupId());

		BlogsEntry blogsEntry = _blogsEntryLocalService.addEntry(
			user.getUserId(), keyword, RandomTestUtil.randomString(),
			serviceContext);

		_blogsEntries.add(blogsEntry);

		return blogsEntry;
	}

	public List<BlogsEntry> getBlogsEntries() {
		return _blogsEntries;
	}

	public void setUp() {
	}

	public void tearDown() {
	}

	private final List<BlogsEntry> _blogsEntries = new ArrayList<>();
	private final BlogsEntryLocalService _blogsEntryLocalService;

}