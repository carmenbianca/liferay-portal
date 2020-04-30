/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auth;

/**
 * @author     Michael C. Han
 * @deprecated As of Judson (7.1.x), with no direct replacement
 */
@Deprecated
public interface AuthenticatedUserUUIDStore {

	public boolean exists(String userUUID);

	public boolean register(String userUUID);

	public boolean unregister(String userUUID);

}