/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap;

import java.util.List;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;

/**
 * @author Tomas Polesovsky
 */
public class SafeLdapName extends LdapName {

	protected SafeLdapName(List<Rdn> rdns) {
		super(rdns);
	}

	protected SafeLdapName(String name) throws InvalidNameException {
		super(name);
	}

}