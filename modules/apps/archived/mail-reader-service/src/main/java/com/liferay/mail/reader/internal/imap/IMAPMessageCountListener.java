/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.internal.imap;

import com.liferay.mail.reader.exception.MailException;
import com.liferay.mail.reader.model.Account;
import com.liferay.mail.reader.service.FolderLocalServiceUtil;
import com.liferay.mail.reader.service.MessageLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;

/**
 * @author Scott Lee
 */
public class IMAPMessageCountListener implements MessageCountListener {

	public IMAPMessageCountListener(
		User user, Account account, String password) {

		_account = account;

		_imapAccessor = new IMAPAccessor(user, account, password);
	}

	@Override
	public void messagesAdded(MessageCountEvent messageCountEvent) {
		Message[] jxMessages = messageCountEvent.getMessages();

		Folder jxFolder = null;

		try {
			jxFolder = _imapAccessor.openFolder(jxMessages[0].getFolder());

			com.liferay.mail.reader.model.Folder folder =
				FolderLocalServiceUtil.getFolder(
					_account.getAccountId(), jxFolder.getFullName());

			_imapAccessor.storeEnvelopes(
				folder.getFolderId(), jxFolder, jxMessages);
		}
		catch (Exception exception) {
			_log.error("Unable to add messages", exception);
		}
		finally {
			try {
				_imapAccessor.closeFolder(jxFolder, false);
			}
			catch (MailException mailException) {
				_log.error(mailException, mailException);
			}
		}
	}

	@Override
	public void messagesRemoved(MessageCountEvent messageCountEvent) {
		Message[] jxMessages = messageCountEvent.getMessages();

		Folder jxFolder = null;

		try {
			jxFolder = _imapAccessor.openFolder(jxMessages[0].getFolder());

			com.liferay.mail.reader.model.Folder folder =
				FolderLocalServiceUtil.getFolder(
					_account.getAccountId(), jxFolder.getFullName());

			long[] remoteMessageIds = _imapAccessor.getMessageUIDs(
				jxFolder, jxMessages);

			for (long remoteMessageId : remoteMessageIds) {
				com.liferay.mail.reader.model.Message message =
					MessageLocalServiceUtil.getMessage(
						folder.getFolderId(), remoteMessageId);

				MessageLocalServiceUtil.deleteMessage(message.getMessageId());
			}
		}
		catch (Exception exception) {
			_log.error("Unable to delete messages", exception);
		}
		finally {
			try {
				_imapAccessor.closeFolder(jxFolder, false);
			}
			catch (MailException mailException) {
				_log.error(mailException, mailException);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		IMAPMessageCountListener.class);

	private final Account _account;
	private final IMAPAccessor _imapAccessor;

}