/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.kernel.model;

/**
 * @author Thiago Moreira
 */
public class IMAPAccount extends Account {

	protected IMAPAccount(String protocol, boolean secure, int port) {
		super(protocol, secure, port);
	}

}