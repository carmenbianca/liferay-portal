/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.security.ldap.validator.LDAPFilterException;
import com.liferay.portal.security.ldap.validator.LDAPFilterValidator;

import java.util.Collections;

/**
 * @author Tomas Polesovsky
 */
public class SafeLdapFilterFactory {

	public static SafeLdapFilter fromUnsafeFilter(
			String unsafeFilter, LDAPFilterValidator ldapFilterValidator)
		throws LDAPFilterException {

		ldapFilterValidator.validate(unsafeFilter);

		return new SafeLdapFilter(
			new StringBundler(unsafeFilter), Collections.emptyList());
	}

}