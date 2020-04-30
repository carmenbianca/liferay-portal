/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Jonathan McCann
 */
public class DuplicateLDAPServerNameException extends PortalException {

	public DuplicateLDAPServerNameException() {
	}

	public DuplicateLDAPServerNameException(String msg) {
		super(msg);
	}

	public DuplicateLDAPServerNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateLDAPServerNameException(Throwable cause) {
		super(cause);
	}

}