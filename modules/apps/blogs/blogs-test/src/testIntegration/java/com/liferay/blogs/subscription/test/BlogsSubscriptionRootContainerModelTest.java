/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.subscription.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.blogs.test.util.BlogsTestUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.SynchronousMailTestRule;
import com.liferay.subscription.test.util.BaseSubscriptionRootContainerModelTestCase;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Sergio González
 * @author Roberto Díaz
 */
@RunWith(Arquillian.class)
public class BlogsSubscriptionRootContainerModelTest
	extends BaseSubscriptionRootContainerModelTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), SynchronousMailTestRule.INSTANCE);

	@Override
	public void testSubscriptionRootContainerModelWhenAddingBaseModelInContainerModel() {
	}

	@Override
	public void testSubscriptionRootContainerModelWhenAddingBaseModelInSubcontainerModel() {
	}

	@Override
	public void testSubscriptionRootContainerModelWhenUpdatingBaseModelInContainerModel() {
	}

	@Override
	public void testSubscriptionRootContainerModelWhenUpdatingBaseModelInSubcontainerModel() {
	}

	@Override
	protected long addBaseModel(long userId, long containerModelId)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				group.getGroupId(), userId);

		BlogsTestUtil.populateNotificationsServiceContext(
			serviceContext, Constants.ADD);

		BlogsEntry entry = BlogsEntryLocalServiceUtil.addEntry(
			userId, RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), serviceContext);

		return entry.getEntryId();
	}

	@Override
	protected void addSubscriptionContainerModel(long containerModelId)
		throws Exception {

		BlogsEntryLocalServiceUtil.subscribe(
			user.getUserId(), group.getGroupId());
	}

	@Override
	protected void updateBaseModel(long userId, long baseModelId)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				group.getGroupId(), userId);

		BlogsTestUtil.populateNotificationsServiceContext(
			serviceContext, Constants.UPDATE);

		serviceContext.setAttribute("sendEmailEntryUpdated", Boolean.TRUE);

		BlogsEntryLocalServiceUtil.updateEntry(
			userId, baseModelId, RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), serviceContext);
	}

}