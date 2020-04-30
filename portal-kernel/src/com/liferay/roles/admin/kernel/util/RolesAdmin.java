/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.admin.kernel.util;

import com.liferay.portal.kernel.model.Role;

/**
 * @author Brian Wing Shun Chan
 */
public interface RolesAdmin {

	public String getIconCssClass(Role role);

}