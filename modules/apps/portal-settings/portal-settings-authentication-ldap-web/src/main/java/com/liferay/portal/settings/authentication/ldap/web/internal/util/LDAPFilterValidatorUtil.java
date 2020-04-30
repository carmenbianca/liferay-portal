/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.authentication.ldap.web.internal.util;

import com.liferay.portal.security.ldap.validator.LDAPFilterValidator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Shuyang Zhou
 */
@Component(immediate = true, service = {})
public class LDAPFilterValidatorUtil {

	public static LDAPFilterValidator getLDAPFilterValidator() {
		return _ldapFilterValidator;
	}

	@Reference(unbind = "-")
	protected void setLDAPFilterValidator(
		LDAPFilterValidator ldapFilterValidator) {

		_ldapFilterValidator = ldapFilterValidator;
	}

	private static LDAPFilterValidator _ldapFilterValidator;

}