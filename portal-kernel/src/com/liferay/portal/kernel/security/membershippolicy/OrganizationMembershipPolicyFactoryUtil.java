/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.membershippolicy;

/**
 * @author Roberto Díaz
 */
public class OrganizationMembershipPolicyFactoryUtil {

	public static OrganizationMembershipPolicy
		getOrganizationMembershipPolicy() {

		return getOrganizationMembershipPolicyFactory().
			getOrganizationMembershipPolicy();
	}

	public static OrganizationMembershipPolicyFactory
		getOrganizationMembershipPolicyFactory() {

		return _organizationMembershipPolicyFactory;
	}

	public void setOrganizationMembershipPolicyFactory(
		OrganizationMembershipPolicyFactory
			organizationMembershipPolicyFactory) {

		_organizationMembershipPolicyFactory =
			organizationMembershipPolicyFactory;
	}

	private static OrganizationMembershipPolicyFactory
		_organizationMembershipPolicyFactory;

}