/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.app.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.document.library.kernel.model.DLFileEntryConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.sync.constants.DLSyncConstants;
import com.liferay.document.library.test.util.BaseDLAppTestCase;
import com.liferay.document.library.workflow.WorkflowHandlerInvocationCounter;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Alexander Chow
 */
@RunWith(Arquillian.class)
public class DLAppServiceWhenRevertingAFileEntryTest extends BaseDLAppTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testShouldCallWorkflowHandler() throws Exception {
		try (WorkflowHandlerInvocationCounter<FileEntry>
				workflowHandlerInvocationCounter =
					new WorkflowHandlerInvocationCounter<>(
						DLFileEntryConstants.getClassName())) {

			FileEntry fileEntry = DLAppServiceTestUtil.addFileEntry(
				group.getGroupId(), parentFolder.getFolderId());

			Assert.assertEquals(
				1,
				workflowHandlerInvocationCounter.getCount(
					"updateStatus", int.class, Map.class));

			String version = fileEntry.getVersion();

			DLAppServiceTestUtil.updateFileEntry(
				group.getGroupId(), fileEntry.getFileEntryId(),
				RandomTestUtil.randomString(), true);

			Assert.assertEquals(
				2,
				workflowHandlerInvocationCounter.getCount(
					"updateStatus", int.class, Map.class));

			ServiceContext serviceContext =
				ServiceContextTestUtil.getServiceContext(group.getGroupId());

			DLAppServiceUtil.revertFileEntry(
				fileEntry.getFileEntryId(), version, serviceContext);

			Assert.assertEquals(
				3,
				workflowHandlerInvocationCounter.getCount(
					"updateStatus", int.class, Map.class));
		}
	}

	@Test
	public void testShouldFireSyncEvent() throws Exception {
		AtomicInteger updateCounter =
			DLAppServiceTestUtil.registerDLSyncEventProcessorMessageListener(
				DLSyncConstants.EVENT_UPDATE);

		FileEntry fileEntry = DLAppServiceTestUtil.addFileEntry(
			group.getGroupId(), parentFolder.getFolderId());

		String version = fileEntry.getVersion();

		Assert.assertEquals(0, updateCounter.get());

		DLAppServiceTestUtil.updateFileEntry(
			group.getGroupId(), fileEntry.getFileEntryId(),
			RandomTestUtil.randomString(), true);

		Assert.assertEquals(2, updateCounter.get());

		DLAppServiceUtil.revertFileEntry(
			fileEntry.getFileEntryId(), version,
			ServiceContextTestUtil.getServiceContext(group.getGroupId()));

		Assert.assertEquals(4, updateCounter.get());
	}

}