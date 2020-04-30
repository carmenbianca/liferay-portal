/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.permission.contributor;

/**
 * @author Sergio González
 */
public interface PermissionSQLContributor {

	public String getPermissionSQL(
		String className, String classPKField, String userIdField,
		String groupIdField, long[] groupIds);

}