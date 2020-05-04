/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.social.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.social.activity.test.util.BaseSocialActivityInterpreterTestCase;
import com.liferay.social.kernel.model.SocialActivityConstants;
import com.liferay.social.kernel.model.SocialActivityInterpreter;
import com.liferay.trash.model.TrashEntry;
import com.liferay.trash.service.TrashEntryLocalServiceUtil;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;
import com.liferay.wiki.social.WikiActivityKeys;
import com.liferay.wiki.test.util.WikiTestUtil;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Zsolt Berentey
 */
@RunWith(Arquillian.class)
public class WikiActivityInterpreterTest
	extends BaseSocialActivityInterpreterTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Override
	protected void addActivities() throws Exception {
		WikiNode wikiNode = WikiTestUtil.addNode(group.getGroupId());

		_page = WikiTestUtil.addPage(
			group.getGroupId(), wikiNode.getNodeId(), true);

		_attachmentFileName = RandomTestUtil.randomString() + ".docx";

		WikiTestUtil.addWikiAttachment(
			_page.getUserId(), _page.getNodeId(), _page.getTitle(),
			_attachmentFileName, getClass());
	}

	@Override
	protected SocialActivityInterpreter getActivityInterpreter() {
		return getActivityInterpreter(
			WikiPortletKeys.WIKI, WikiPage.class.getName());
	}

	@Override
	protected int[] getActivityTypes() {
		return new int[] {
			SocialActivityConstants.TYPE_ADD_ATTACHMENT,
			SocialActivityConstants.TYPE_MOVE_ATTACHMENT_TO_TRASH,
			SocialActivityConstants.TYPE_MOVE_TO_TRASH,
			SocialActivityConstants.TYPE_RESTORE_ATTACHMENT_FROM_TRASH,
			SocialActivityConstants.TYPE_RESTORE_FROM_TRASH,
			WikiActivityKeys.ADD_PAGE, WikiActivityKeys.UPDATE_PAGE
		};
	}

	@Override
	protected boolean isSupportsRename(String className) {
		return false;
	}

	@Override
	protected void moveModelsToTrash() throws Exception {
		WikiPageLocalServiceUtil.movePageAttachmentToTrash(
			TestPropsValues.getUserId(), _page.getNodeId(), _page.getTitle(),
			_attachmentFileName);

		_page = WikiPageLocalServiceUtil.movePageToTrash(
			TestPropsValues.getUserId(), _page);
	}

	@Override
	protected void renameModels() throws Exception {
	}

	@Override
	protected void restoreModelsFromTrash() throws Exception {
		TrashEntry trashEntry = TrashEntryLocalServiceUtil.getEntry(
			WikiPage.class.getName(), _page.getResourcePrimKey());

		String trashTitle = trashHelper.getTrashTitle(trashEntry.getEntryId());

		_page.setTitle(trashTitle);

		WikiPageLocalServiceUtil.restorePageAttachmentFromTrash(
			TestPropsValues.getUserId(), _page.getNodeId(), _page.getTitle(),
			_attachmentFileName);

		WikiPageLocalServiceUtil.restorePageFromTrash(
			TestPropsValues.getUserId(), _page);
	}

	private String _attachmentFileName;
	private WikiPage _page;

}