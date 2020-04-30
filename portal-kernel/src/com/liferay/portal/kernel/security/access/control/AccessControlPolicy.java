/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.access.control;

import java.lang.reflect.Method;

/**
 * @author Tomas Polesovsky
 */
public interface AccessControlPolicy {

	public void onServiceAccess(
			Method method, Object[] arguments,
			AccessControlled accessControlled)
		throws SecurityException;

	public void onServiceRemoteAccess(
			Method method, Object[] arguments,
			AccessControlled accessControlled)
		throws SecurityException;

}