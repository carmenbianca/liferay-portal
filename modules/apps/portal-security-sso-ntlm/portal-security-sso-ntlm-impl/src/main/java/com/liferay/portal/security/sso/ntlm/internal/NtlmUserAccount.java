/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.ntlm.internal;

import java.io.Serializable;

/**
 * @author Marcellus Tavares
 */
public class NtlmUserAccount implements Serializable {

	public NtlmUserAccount(String userName) {
		_userName = userName;
	}

	public String getUserName() {
		return _userName;
	}

	private final String _userName;

}