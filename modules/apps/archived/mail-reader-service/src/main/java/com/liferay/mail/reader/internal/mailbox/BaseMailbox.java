/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.internal.mailbox;

import com.liferay.mail.reader.exception.MailException;
import com.liferay.mail.reader.exception.NoSuchAccountException;
import com.liferay.mail.reader.mailbox.Mailbox;
import com.liferay.mail.reader.model.Account;
import com.liferay.mail.reader.service.AccountLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

/**
 * @author Scott Lee
 */
public abstract class BaseMailbox implements Mailbox {

	@Override
	public Account addAccount(
			String address, String personalName, String protocol,
			String incomingHostName, int incomingPort, boolean incomingSecure,
			String outgoingHostName, int outgoingPort, boolean outgoingSecure,
			String login, String password, boolean savePassword,
			String signature, boolean useSignature, String folderPrefix,
			boolean defaultSender)
		throws PortalException {

		validateAccount(
			incomingHostName, incomingPort, incomingSecure, outgoingHostName,
			outgoingPort, outgoingSecure, login, password);

		try {
			AccountLocalServiceUtil.getAccount(user.getUserId(), address);

			throw new MailException(MailException.ACCOUNT_ALREADY_EXISTS);
		}
		catch (NoSuchAccountException noSuchAccountException) {
			long inboxFolderId = 0;
			long draftFolderId = 0;
			long sentFolderId = 0;
			long trashFolderId = 0;

			return AccountLocalServiceUtil.addAccount(
				user.getUserId(), address, personalName, protocol,
				incomingHostName, incomingPort, incomingSecure,
				outgoingHostName, outgoingPort, outgoingSecure, login, password,
				savePassword, signature, useSignature, folderPrefix,
				inboxFolderId, draftFolderId, sentFolderId, trashFolderId,
				defaultSender);
		}
	}

	@Override
	public void deleteAccount() throws PortalException {
		AccountLocalServiceUtil.deleteAccount(account.getAccountId());
	}

	@Override
	public Account getAccount() {
		return account;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Account updateAccount(
			long accountId, String personalName, String password,
			boolean savePassword, String signature, boolean useSignature,
			String folderPrefix, boolean defaultSender)
		throws PortalException {

		Account account = AccountLocalServiceUtil.getAccount(accountId);

		validateAccount(
			account.getIncomingHostName(), account.getIncomingPort(),
			account.isIncomingSecure(), account.getOutgoingHostName(),
			account.getOutgoingPort(), account.isOutgoingSecure(),
			account.getLogin(), password);

		return AccountLocalServiceUtil.updateAccount(
			accountId, personalName, password, savePassword, signature,
			useSignature, folderPrefix, defaultSender);
	}

	@Override
	public void updateFolders(
			long inboxFolderId, long draftFolderId, long sentFolderId,
			long trashFolderId)
		throws PortalException {

		AccountLocalServiceUtil.updateFolders(
			account.getAccountId(), inboxFolderId, draftFolderId, sentFolderId,
			trashFolderId);
	}

	protected Account account;
	protected User user;

}