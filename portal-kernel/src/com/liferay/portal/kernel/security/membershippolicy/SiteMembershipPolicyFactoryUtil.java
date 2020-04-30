/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.membershippolicy;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteMembershipPolicyFactoryUtil {

	public static SiteMembershipPolicy getSiteMembershipPolicy() {
		return getSiteMembershipPolicyFactory().getSiteMembershipPolicy();
	}

	public static SiteMembershipPolicyFactory getSiteMembershipPolicyFactory() {
		return _siteMembershipPolicyFactory;
	}

	public void setSiteMembershipPolicyFactory(
		SiteMembershipPolicyFactory siteMembershipPolicyFactory) {

		_siteMembershipPolicyFactory = siteMembershipPolicyFactory;
	}

	private static SiteMembershipPolicyFactory _siteMembershipPolicyFactory;

}