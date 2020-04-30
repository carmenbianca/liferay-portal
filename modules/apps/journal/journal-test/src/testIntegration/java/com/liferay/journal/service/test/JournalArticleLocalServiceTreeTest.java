/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.model.JournalFolderConstants;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.journal.test.util.JournalTestUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Shinn Lok
 */
@RunWith(Arquillian.class)
public class JournalArticleLocalServiceTreeTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();
	}

	@Test
	public void testJournalArticleTreePathWhenMovingSubfolderWithArticle()
		throws Exception {

		JournalFolder folderA = JournalTestUtil.addFolder(
			_group.getGroupId(),
			JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Folder A");

		JournalFolder folderAA = JournalTestUtil.addFolder(
			_group.getGroupId(), folderA.getFolderId(), "Folder AA");

		JournalArticle article = JournalTestUtil.addArticle(
			_group.getGroupId(), folderAA.getFolderId());

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(_group.getGroupId());

		JournalFolderLocalServiceUtil.moveFolder(
			folderAA.getFolderId(),
			JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID, serviceContext);

		article = JournalArticleLocalServiceUtil.getArticle(
			_group.getGroupId(), article.getArticleId());

		Assert.assertEquals(article.buildTreePath(), article.getTreePath());
	}

	@Test
	public void testRebuildTree() throws Exception {
		List<JournalArticle> articles = createTree();

		for (JournalArticle article : articles) {
			article.setTreePath("/0/");

			JournalArticleLocalServiceUtil.updateJournalArticle(article);
		}

		JournalArticleLocalServiceUtil.rebuildTree(
			TestPropsValues.getCompanyId());

		for (JournalArticle article : articles) {
			article = JournalArticleLocalServiceUtil.getArticle(
				article.getId());

			Assert.assertEquals(article.buildTreePath(), article.getTreePath());
		}
	}

	protected List<JournalArticle> createTree() throws Exception {
		List<JournalArticle> articles = new ArrayList<>();

		JournalArticle articleA = JournalTestUtil.addArticle(
			_group.getGroupId(), "Article A", RandomTestUtil.randomString());

		articles.add(articleA);

		JournalFolder folder = JournalTestUtil.addFolder(
			_group.getGroupId(), "Folder A");

		JournalArticle articleAA = JournalTestUtil.addArticle(
			_group.getGroupId(), folder.getFolderId(), "Article AA",
			RandomTestUtil.randomString());

		articles.add(articleAA);

		return articles;
	}

	@DeleteAfterTestRun
	private Group _group;

}