/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission;

import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;

/**
 * @author Michael C. Han
 */
public interface PermissionConversionFilter {

	public boolean accept(Role role, ResourcePermission resourcePermission);

}