/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.axis;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * @author Brian Wing Shun Chan
 */
public class SimpleAuthenticator extends Authenticator {

	public SimpleAuthenticator(String userName, String password) {
		_authentication = new PasswordAuthentication(
			userName, password.toCharArray());
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return _authentication;
	}

	private final PasswordAuthentication _authentication;

}