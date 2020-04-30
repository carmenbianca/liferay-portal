/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.mailbox;

import com.liferay.mail.reader.model.Account;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

/**
 * @author Scott Lee
 */
public interface MailboxFactory {

	public Mailbox getMailbox(User user, Account account, String password);

	public Mailbox getMailbox(User user, String protocol);

	public String getMailboxFactoryName();

	public void initialize() throws PortalException;

}