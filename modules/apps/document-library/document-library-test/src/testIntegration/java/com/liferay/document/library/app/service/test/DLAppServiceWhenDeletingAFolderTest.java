/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.app.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLTrashServiceUtil;
import com.liferay.document.library.sync.constants.DLSyncConstants;
import com.liferay.document.library.test.util.BaseDLAppTestCase;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

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
public class DLAppServiceWhenDeletingAFolderTest extends BaseDLAppTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testShouldDeleteImplicitlyTrashedChildFolder()
		throws Exception {

		int initialFoldersCount = DLAppServiceUtil.getFoldersCount(
			group.getGroupId(), parentFolder.getFolderId());

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(group.getGroupId());

		Folder folder = DLAppServiceUtil.addFolder(
			group.getGroupId(), parentFolder.getFolderId(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			serviceContext);

		DLAppServiceUtil.addFolder(
			group.getGroupId(), folder.getFolderId(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			serviceContext);

		DLTrashServiceUtil.moveFolderToTrash(folder.getFolderId());

		DLAppServiceUtil.deleteFolder(folder.getFolderId());

		int foldersCount = DLAppServiceUtil.getFoldersCount(
			group.getGroupId(), parentFolder.getFolderId());

		Assert.assertEquals(initialFoldersCount, foldersCount);
	}

	@Test
	public void testShouldFireSyncEvent() throws Exception {
		AtomicInteger counter =
			DLAppServiceTestUtil.registerDLSyncEventProcessorMessageListener(
				DLSyncConstants.EVENT_DELETE);

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(group.getGroupId());

		Folder folder = DLAppServiceUtil.addFolder(
			group.getGroupId(), parentFolder.getFolderId(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			serviceContext);

		DLAppServiceUtil.deleteFolder(folder.getFolderId());

		Assert.assertEquals(1, counter.get());
	}

	@Test
	public void testShouldSkipExplicitlyTrashedChildFolder() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(group.getGroupId());

		Folder folder = DLAppServiceUtil.addFolder(
			group.getGroupId(), parentFolder.getFolderId(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			serviceContext);

		Folder subfolder = DLAppServiceUtil.addFolder(
			group.getGroupId(), folder.getFolderId(),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			serviceContext);

		DLTrashServiceUtil.moveFolderToTrash(subfolder.getFolderId());

		DLTrashServiceUtil.moveFolderToTrash(folder.getFolderId());

		DLAppServiceUtil.deleteFolder(folder.getFolderId());

		DLAppServiceUtil.getFolder(subfolder.getFolderId());
	}

}