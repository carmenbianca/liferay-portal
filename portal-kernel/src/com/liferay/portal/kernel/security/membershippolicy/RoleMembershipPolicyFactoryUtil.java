/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.membershippolicy;

/**
 * @author Roberto Díaz
 */
public class RoleMembershipPolicyFactoryUtil {

	public static RoleMembershipPolicy getRoleMembershipPolicy() {
		return getRoleMembershipPolicyFactory().getRoleMembershipPolicy();
	}

	public static RoleMembershipPolicyFactory getRoleMembershipPolicyFactory() {
		return _roleMembershipPolicyFactory;
	}

	public void setRoleMembershipPolicyFactory(
		RoleMembershipPolicyFactory roleMembershipPolicyFactory) {

		_roleMembershipPolicyFactory = roleMembershipPolicyFactory;
	}

	private static RoleMembershipPolicyFactory _roleMembershipPolicyFactory;

}