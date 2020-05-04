/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth;

import java.io.Serializable;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalCallbackHandler implements CallbackHandler, Serializable {

	public PortalCallbackHandler(String name, String password) {
		_name = name;
		_password = password;
	}

	@Override
	public void handle(Callback[] callbacks) {
		for (Callback callback : callbacks) {
			if (callback instanceof NameCallback) {
				NameCallback nameCallback = (NameCallback)callback;

				nameCallback.setName(_name);
			}
			else if (callback instanceof PasswordCallback) {
				PasswordCallback passCallback = (PasswordCallback)callback;

				passCallback.setPassword(_password.toCharArray());
			}
		}
	}

	private final String _name;
	private final String _password;

}