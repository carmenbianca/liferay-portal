/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.search.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.message.boards.constants.MBCategoryConstants;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.rule.Sync;
import com.liferay.portal.kernel.test.rule.SynchronousDestinationTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.search.test.util.IndexerFixture;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;
import com.liferay.users.admin.test.util.search.UserSearchFixture;

import java.util.List;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Luan Maoski
 */
@RunWith(Arquillian.class)
@Sync
public class MBMessageIndexerReindexTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE,
			SynchronousDestinationTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		setUpUserSearchFixture();
		setUpMBFixture();
		setUpMBMessageIndexerFixture();
	}

	@Test
	public void testReindexMBMessage() throws Exception {
		String searchTerm = RandomTestUtil.randomString();

		MBMessage mbMessage = mbFixture.createMBMessageWithCategory(searchTerm);

		mbMessageIndexerFixture.searchOnlyOne(searchTerm);

		Document document = mbMessageIndexerFixture.searchOnlyOne(searchTerm);

		mbMessageIndexerFixture.deleteDocument(document);

		mbMessageIndexerFixture.searchNoOne(searchTerm);

		mbMessageIndexerFixture.reindex(mbMessage.getCompanyId());

		mbMessageIndexerFixture.searchOnlyOne(searchTerm);
	}

	@Test
	public void testReindexMBMessageWithDefaultCategory() throws Exception {
		String searchTerm = RandomTestUtil.randomString();

		MBMessage mbMessage = mbFixture.createMBMessage(
			MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID, searchTerm);

		mbMessageIndexerFixture.searchOnlyOne(searchTerm);

		Document document = mbMessageIndexerFixture.searchOnlyOne(searchTerm);

		mbMessageIndexerFixture.deleteDocument(document);

		mbMessageIndexerFixture.searchNoOne(searchTerm);

		mbMessageIndexerFixture.reindex(mbMessage.getCompanyId());

		mbMessageIndexerFixture.searchOnlyOne(searchTerm);
	}

	@Test
	public void testReindexMBMessageWithDiscussion() throws Exception {
		String searchTerm = RandomTestUtil.randomString();

		mbFixture.createMBMessage(
			MBCategoryConstants.DISCUSSION_CATEGORY_ID, searchTerm);

		mbMessageIndexerFixture.searchNoOne(searchTerm);
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected void setUpMBFixture() {
		mbFixture = new MBFixture(_group, _user);

		_mbMessages = mbFixture.getMbMessages();

		_mbThreads = mbFixture.getMbThreads();
	}

	protected void setUpMBMessageIndexerFixture() {
		mbMessageIndexerFixture = new IndexerFixture<>(MBMessage.class);
	}

	protected void setUpUserSearchFixture() throws Exception {
		userSearchFixture = new UserSearchFixture();

		userSearchFixture.setUp();

		_group = userSearchFixture.addGroup();

		_groups = userSearchFixture.getGroups();

		_user = userSearchFixture.addUser(
			RandomTestUtil.randomString(), _group);

		_users = userSearchFixture.getUsers();
	}

	protected MBFixture mbFixture;
	protected IndexerFixture<MBMessage> mbMessageIndexerFixture;
	protected UserSearchFixture userSearchFixture;

	private Group _group;

	@DeleteAfterTestRun
	private List<Group> _groups;

	@DeleteAfterTestRun
	private List<MBMessage> _mbMessages;

	@DeleteAfterTestRun
	private List<MBThread> _mbThreads;

	private User _user;

	@DeleteAfterTestRun
	private List<User> _users;

}