/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission;

/**
 * @author Gergely Mathe
 */
public interface PermissionUpdateHandler {

	public void updatedPermission(String primKey);

}