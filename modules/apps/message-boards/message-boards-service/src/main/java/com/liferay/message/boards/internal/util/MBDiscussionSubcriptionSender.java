/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.util;

import com.liferay.comment.configuration.CommentGroupServiceConfiguration;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.SubscriptionSender;

/**
 * @author Roberto Díaz
 */
public class MBDiscussionSubcriptionSender extends SubscriptionSender {

	public MBDiscussionSubcriptionSender(
		CommentGroupServiceConfiguration commentGroupServiceConfiguration) {

		_commentGroupServiceConfiguration = commentGroupServiceConfiguration;
	}

	@Override
	protected void sendEmailNotification(User user) throws Exception {
		if ((_commentGroupServiceConfiguration == null) ||
			!_commentGroupServiceConfiguration.
				discussionEmailCommentsAddedEnabled()) {

			return;
		}

		super.sendEmailNotification(user);
	}

	private final CommentGroupServiceConfiguration
		_commentGroupServiceConfiguration;

}