/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.model.JournalFolderConstants;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.journal.test.util.JournalTestUtil;
import com.liferay.portal.kernel.model.TreeModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.local.service.tree.test.util.BaseLocalServiceTreeTestCase;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Shinn Lok
 */
@RunWith(Arquillian.class)
public class JournalFolderLocalServiceTreeTest
	extends BaseLocalServiceTreeTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testJournalFolderTreePathWhenMovingFolderWithSubfolder()
		throws Exception {

		List<JournalFolder> folders = new ArrayList<>();

		JournalFolder folderA = JournalTestUtil.addFolder(
			group.getGroupId(), JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID,
			"Folder A");

		folders.add(folderA);

		JournalFolder folderAA = JournalTestUtil.addFolder(
			group.getGroupId(), folderA.getFolderId(), "Folder AA");

		folders.add(folderAA);

		JournalFolder folderAAA = JournalTestUtil.addFolder(
			group.getGroupId(), folderAA.getFolderId(), "Folder AAA");

		folders.add(folderAAA);

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(group.getGroupId());

		JournalFolderLocalServiceUtil.moveFolder(
			folderAA.getFolderId(),
			JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID, serviceContext);

		for (JournalFolder folder : folders) {
			folder = JournalFolderLocalServiceUtil.fetchFolder(
				folder.getFolderId());

			Assert.assertEquals(folder.buildTreePath(), folder.getTreePath());
		}
	}

	@Override
	protected TreeModel addTreeModel(TreeModel parentTreeModel)
		throws Exception {

		long parentFolderId = JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		if (parentTreeModel != null) {
			JournalFolder folder = (JournalFolder)parentTreeModel;

			parentFolderId = folder.getFolderId();
		}

		JournalFolder folder = JournalTestUtil.addFolder(
			group.getGroupId(), parentFolderId, RandomTestUtil.randomString());

		folder.setTreePath("/0/");

		return JournalFolderLocalServiceUtil.updateJournalFolder(folder);
	}

	@Override
	protected void deleteTreeModel(TreeModel treeModel) throws Exception {
		JournalFolder folder = (JournalFolder)treeModel;

		JournalFolderLocalServiceUtil.deleteFolder(folder);
	}

	@Override
	protected TreeModel getTreeModel(long primaryKey) throws Exception {
		return JournalFolderLocalServiceUtil.getFolder(primaryKey);
	}

	@Override
	protected void rebuildTree() throws Exception {
		JournalFolderLocalServiceUtil.rebuildTree(
			TestPropsValues.getCompanyId());
	}

}