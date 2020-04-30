/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.admin.kernel.util;

import com.liferay.portal.kernel.model.User;

/**
 * @author Michael C. Han
 */
public interface Omniadmin {

	public boolean isOmniadmin(long userId);

	public boolean isOmniadmin(User user);

}