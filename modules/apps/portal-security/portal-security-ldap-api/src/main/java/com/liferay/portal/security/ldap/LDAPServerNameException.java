/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Jonathan McCann
 */
public class LDAPServerNameException extends PortalException {

	public LDAPServerNameException() {
	}

	public LDAPServerNameException(String msg) {
		super(msg);
	}

	public LDAPServerNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LDAPServerNameException(Throwable cause) {
		super(cause);
	}

}