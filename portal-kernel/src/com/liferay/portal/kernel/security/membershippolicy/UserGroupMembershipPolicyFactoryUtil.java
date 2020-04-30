/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.membershippolicy;

/**
 * @author Roberto Díaz
 */
public class UserGroupMembershipPolicyFactoryUtil {

	public static UserGroupMembershipPolicy getUserGroupMembershipPolicy() {
		return getUserGroupMembershipPolicyFactory().
			getUserGroupMembershipPolicy();
	}

	public static UserGroupMembershipPolicyFactory
		getUserGroupMembershipPolicyFactory() {

		return _userGroupMembershipPolicyFactory;
	}

	public void setUserGroupMembershipPolicyFactory(
		UserGroupMembershipPolicyFactory userGroupMembershipPolicyFactory) {

		_userGroupMembershipPolicyFactory = userGroupMembershipPolicyFactory;
	}

	private static UserGroupMembershipPolicyFactory
		_userGroupMembershipPolicyFactory;

}