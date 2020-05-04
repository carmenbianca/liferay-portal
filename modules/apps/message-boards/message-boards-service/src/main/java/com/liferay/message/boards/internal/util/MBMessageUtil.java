/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.util;

import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.service.persistence.MBMessageFinder;
import com.liferay.message.boards.service.persistence.MBMessagePersistence;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Comparator;
import java.util.List;

/**
 * @author Preston Crary
 */
public class MBMessageUtil {

	public static List<MBMessage> getThreadMessages(
		MBMessagePersistence mbMessagePersistence,
		MBMessageFinder mbMessageFinder, long userId, long threadId, int status,
		int start, int end, Comparator<MBMessage> comparator) {

		if (status == WorkflowConstants.STATUS_ANY) {
			OrderByComparator<MBMessage> orderByComparator = null;

			if (comparator instanceof OrderByComparator) {
				orderByComparator = (OrderByComparator<MBMessage>)comparator;
			}

			List<MBMessage> messages = mbMessagePersistence.findByT_notS(
				threadId, WorkflowConstants.STATUS_IN_TRASH, start, end,
				orderByComparator);

			if (!(comparator instanceof OrderByComparator)) {
				messages = ListUtil.sort(messages, comparator);
			}

			return messages;
		}

		QueryDefinition<MBMessage> queryDefinition = new QueryDefinition<>(
			status, userId, true, start, end, null);

		if (comparator instanceof OrderByComparator) {
			queryDefinition.setOrderByComparator(
				(OrderByComparator<MBMessage>)comparator);
		}

		List<MBMessage> messages = mbMessageFinder.findByThreadId(
			threadId, queryDefinition);

		if (!(comparator instanceof OrderByComparator)) {
			messages = ListUtil.sort(messages, comparator);
		}

		return messages;
	}

	public static void updateAnswer(
		MBMessagePersistence mbMessagePersistence, MBMessage message,
		boolean answer, boolean cascade) {

		if (message.isAnswer() != answer) {
			message.setAnswer(answer);

			message = mbMessagePersistence.update(message);
		}

		if (cascade) {
			List<MBMessage> messages = mbMessagePersistence.findByT_P(
				message.getThreadId(), message.getMessageId());

			for (MBMessage curMessage : messages) {
				updateAnswer(mbMessagePersistence, curMessage, answer, cascade);
			}
		}
	}

	private MBMessageUtil() {
	}

}