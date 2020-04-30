/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Tomas Polesovsky
 */
@ProviderType
public interface SafeLdapContext extends LdapContext {

	public NamingEnumeration<SearchResult> search(
			SafeLdapName safeLdapName, SafeLdapFilter safeLdapFilter,
			SearchControls searchControls)
		throws NamingException;

}