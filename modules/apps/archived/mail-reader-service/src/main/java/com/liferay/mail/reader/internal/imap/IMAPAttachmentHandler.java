/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.internal.imap;

import com.liferay.mail.reader.internal.attachment.DefaultAttachmentHandler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.InputStream;

import javax.mail.Folder;
import javax.mail.MessagingException;

/**
 * @author Ryan Park
 */
public class IMAPAttachmentHandler extends DefaultAttachmentHandler {

	public IMAPAttachmentHandler(InputStream inputStream, Folder folder) {
		super(inputStream, folder);
	}

	@Override
	public void cleanUp() {
		try {
			Folder folder = getFolder();

			if ((folder == null) || !folder.isOpen()) {
				return;
			}

			folder.close(false);
		}
		catch (MessagingException messagingException) {
			_log.error(messagingException, messagingException);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		IMAPAttachmentHandler.class);

}