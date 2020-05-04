/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.internal.exportimport;

import javax.naming.InvalidNameException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jorge Díaz
 */
public class LDAPUserImporterImplTest {

	@Test
	public void testBindingInNamespaceEscape() throws InvalidNameException {
		Assert.assertEquals(
			"cn=User\\\\,with\\\\,commas,ou=users,dc=example,dc=com",
			escapeLDAPName(
				"cn=User\\,with\\,commas,ou=users,dc=example,dc=com"));
		Assert.assertEquals(
			"cn=User\\\\2cwith\\\\2ccommas,ou=users,dc=example,dc=com",
			escapeLDAPName(
				"cn=User\\2cwith\\2ccommas,ou=users,dc=example,dc=com"));
	}

	protected String escapeLDAPName(String query) {
		return _ldapUserImporterImpl.escapeLDAPName(query);
	}

	private static final LDAPUserImporterImpl _ldapUserImporterImpl =
		new LDAPUserImporterImpl();

}