/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission.contributor;

/**
 * RoleContributors are invoked during permission checking allowing the roles
 * calculated from persisted assignment and inheritance to be altered
 * dynamically. Implementations must make every attempt to be as efficient as
 * possible or risk potentially dramatic performance degradation.
 *
 * @author Raymond Augé
 * @review
 */
public interface RoleContributor {

	public void contribute(RoleCollection roleCollection);

}