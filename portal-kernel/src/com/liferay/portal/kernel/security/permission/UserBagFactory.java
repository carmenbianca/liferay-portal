/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Preston Crary
 */
public interface UserBagFactory {

	public UserBag create(long userId) throws PortalException;

}