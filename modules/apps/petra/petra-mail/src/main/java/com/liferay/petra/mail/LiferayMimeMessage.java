/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.mail;

import com.liferay.portal.kernel.util.ArrayUtil;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/**
 * @author Jorge Ferrer
 * @see    com.liferay.util.mail.LiferayMimeMessage
 */
public class LiferayMimeMessage extends MimeMessage {

	public LiferayMimeMessage(Session session) {
		super(session);
	}

	@Override
	protected void updateMessageID() throws MessagingException {
		String[] messageIds = getHeader("Message-ID");

		if (ArrayUtil.isNotEmpty(messageIds)) {

			// Keep current value

			return;
		}

		super.updateMessageID();
	}

}