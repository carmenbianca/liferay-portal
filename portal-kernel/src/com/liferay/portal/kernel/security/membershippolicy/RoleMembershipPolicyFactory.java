/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.membershippolicy;

/**
 * @author Roberto Díaz
 */
public interface RoleMembershipPolicyFactory {

	public RoleMembershipPolicy getRoleMembershipPolicy();

}