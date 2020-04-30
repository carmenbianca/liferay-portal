/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission;

import com.liferay.portal.kernel.model.User;

/**
 * @author Charles May
 * @author Brian Wing Shun Chan
 */
public interface PermissionCheckerFactory {

	public PermissionChecker create(User user);

}