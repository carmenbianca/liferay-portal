/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFileVersionLocalService;
import com.liferay.document.library.kernel.store.DLStoreUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestDataConstants;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Alejandro Tardín
 */
@RunWith(Arquillian.class)
public class DLFileVersionLocalServiceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();
	}

	@Test
	public void testDeleteFileVersionDeletesTheFile() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
			TestPropsValues.getUserId(), _group.getGroupId(),
			DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
			RandomTestUtil.randomString(), ContentTypes.TEXT_PLAIN,
			TestDataConstants.TEST_BYTE_ARRAY, serviceContext);

		DLAppServiceUtil.updateFileEntry(
			fileEntry.getFileEntryId(), null, ContentTypes.TEXT_PLAIN,
			RandomTestUtil.randomString(), StringPool.BLANK, StringPool.BLANK,
			DLVersionNumberIncrease.MINOR, (byte[])null, serviceContext);

		DLFileEntry dlFileEntry = _dlFileEntryLocalService.getDLFileEntry(
			fileEntry.getFileEntryId());

		Assert.assertTrue(
			DLStoreUtil.hasFile(
				dlFileEntry.getCompanyId(), dlFileEntry.getDataRepositoryId(),
				dlFileEntry.getName(), "1.0"));

		_dlFileVersionLocalService.deleteDLFileVersion(
			_dlFileVersionLocalService.getFileVersion(
				fileEntry.getFileEntryId(), "1.0"));

		Assert.assertFalse(
			DLStoreUtil.hasFile(
				dlFileEntry.getCompanyId(), dlFileEntry.getDataRepositoryId(),
				dlFileEntry.getName(), "1.0"));
	}

	@Inject
	private DLFileEntryLocalService _dlFileEntryLocalService;

	@Inject
	private DLFileVersionLocalService _dlFileVersionLocalService;

	@DeleteAfterTestRun
	private Group _group;

}