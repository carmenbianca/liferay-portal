/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.resource.v1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.headless.delivery.client.dto.v1_0.MessageBoardMessage;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.test.util.MBTestUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.search.test.util.SearchTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Javier Gamarra
 */
@RunWith(Arquillian.class)
public class MessageBoardMessageResourceTest
	extends BaseMessageBoardMessageResourceTestCase {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setScopeGroupId(testGroup.getGroupId());
	}

	@Override
	public void testGetMessageBoardMessageMessageBoardMessagesPageWithSortInteger() {
	}

	@Override
	public void testGetMessageBoardThreadMessageBoardMessagesPageWithSortInteger() {
	}

	@Override
	public void testGetSiteMessageBoardMessageByFriendlyUrlPath() {
	}

	@Override
	public void testGetSiteMessageBoardMessagesPageWithSortInteger() {
	}

	@Override
	public void testGraphQLDeleteMessageBoardMessage() {
	}

	@Override
	public void testGraphQLGetMessageBoardMessage() {
	}

	@Override
	public void testGraphQLGetSiteMessageBoardMessageByFriendlyUrlPath() {
	}

	@Override
	public void testGraphQLGetSiteMessageBoardMessagesPage() {
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	@Override
	protected String[] getAdditionalAssertFieldNames() {
		return new String[] {"articleBody", "headline"};
	}

	@Override
	protected String[] getIgnoredEntityFieldNames() {
		return new String[] {"creatorId", "messageBoardSectionId"};
	}

	@Override
	protected MessageBoardMessage randomMessageBoardMessage() throws Exception {
		MessageBoardMessage messageBoardMessage =
			super.randomMessageBoardMessage();

		messageBoardMessage.setMessageBoardSectionId((Long)null);

		return messageBoardMessage;
	}

	@Override
	protected MessageBoardMessage
			testDeleteMessageBoardMessage_addMessageBoardMessage()
		throws Exception {

		return _addMessageBoardMessage();
	}

	@Override
	protected MessageBoardMessage
			testDeleteMessageBoardMessageMyRating_addMessageBoardMessage()
		throws Exception {

		return _addMessageBoardMessage();
	}

	@Override
	protected MessageBoardMessage
			testGetMessageBoardMessage_addMessageBoardMessage()
		throws Exception {

		return _addMessageBoardMessage();
	}

	@Override
	protected Long
			testGetMessageBoardMessageMessageBoardMessagesPage_getParentMessageBoardMessageId()
		throws Exception {

		MBMessage mbMessage = _addMbMessage(
			testGroup.getGroupId(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString());

		return mbMessage.getRootMessageId();
	}

	@Override
	protected Long
			testGetMessageBoardThreadMessageBoardMessagesPage_getMessageBoardThreadId()
		throws Exception {

		MBMessage mbMessage = _addMbMessage(
			testGroup.getGroupId(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString());

		return mbMessage.getThreadId();
	}

	@Override
	protected MessageBoardMessage
			testGetSiteMessageBoardMessagesPage_addMessageBoardMessage(
				Long siteId, MessageBoardMessage messageBoardMessage)
		throws Exception {

		return _addMessageBoardMessage(messageBoardMessage, siteId);
	}

	@Override
	protected MessageBoardMessage
			testPatchMessageBoardMessage_addMessageBoardMessage()
		throws Exception {

		return _addMessageBoardMessage();
	}

	@Override
	protected MessageBoardMessage
			testPutMessageBoardMessage_addMessageBoardMessage()
		throws Exception {

		return _addMessageBoardMessage();
	}

	@Override
	protected MessageBoardMessage
			testPutMessageBoardMessageSubscribe_addMessageBoardMessage()
		throws Exception {

		return _addMessageBoardMessage();
	}

	@Override
	protected MessageBoardMessage
			testPutMessageBoardMessageUnsubscribe_addMessageBoardMessage()
		throws Exception {

		return _addMessageBoardMessage();
	}

	private MBMessage _addMbMessage(Long siteId, String subject, String body)
		throws PortalException {

		MBMessage mbMessage = MBTestUtil.addMessage(
			siteId,
			UserLocalServiceUtil.getDefaultUserId(testGroup.getCompanyId()),
			subject, body);

		_mbThread = mbMessage.getThread();

		return mbMessage;
	}

	private MessageBoardMessage _addMessageBoardMessage() throws Exception {
		return _addMessageBoardMessage(null, testGroup.getGroupId());
	}

	private MessageBoardMessage _addMessageBoardMessage(
			MessageBoardMessage messageBoardMessage, Long siteId)
		throws Exception {

		if (messageBoardMessage != null) {
			MBMessage mbMessage = _addMbMessage(
				siteId, messageBoardMessage.getHeadline(),
				messageBoardMessage.getArticleBody());

			return messageBoardMessageResource.getMessageBoardMessage(
				mbMessage.getMessageId());
		}

		_addMbMessage(
			siteId, RandomTestUtil.randomString(),
			RandomTestUtil.randomString());

		return messageBoardMessageResource.
			postMessageBoardThreadMessageBoardMessage(
				_mbThread.getThreadId(), randomMessageBoardMessage());
	}

	@DeleteAfterTestRun
	private MBThread _mbThread;

}