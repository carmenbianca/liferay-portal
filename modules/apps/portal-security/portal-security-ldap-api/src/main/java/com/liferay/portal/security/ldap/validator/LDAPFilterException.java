/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.validator;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author James Lefeu
 */
public class LDAPFilterException extends PortalException {

	public LDAPFilterException() {
	}

	public LDAPFilterException(String msg) {
		super(msg);
	}

	public LDAPFilterException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LDAPFilterException(Throwable cause) {
		super(cause);
	}

}