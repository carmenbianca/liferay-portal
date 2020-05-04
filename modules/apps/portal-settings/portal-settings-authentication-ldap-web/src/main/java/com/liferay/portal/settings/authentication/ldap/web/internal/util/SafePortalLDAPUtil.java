/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.authentication.ldap.web.internal.util;

import com.liferay.portal.security.ldap.SafePortalLDAP;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Edward C. Han
 */
@Component(immediate = true, service = {})
public class SafePortalLDAPUtil {

	public static SafePortalLDAP getSafePortalLDAP() {
		return _safePortalLDAP;
	}

	@Reference(policyOption = ReferencePolicyOption.GREEDY, unbind = "-")
	protected void setPortalLDAP(SafePortalLDAP safePortalLDAP) {
		_safePortalLDAP = safePortalLDAP;
	}

	private static SafePortalLDAP _safePortalLDAP;

}