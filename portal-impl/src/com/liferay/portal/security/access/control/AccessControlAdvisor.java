/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.access.control;

import com.liferay.portal.kernel.security.access.control.AccessControlled;

import java.lang.reflect.Method;

/**
 * @author Michael C. Han
 * @author Raymond Augé
 */
public interface AccessControlAdvisor {

	public void accept(
			Method method, Object[] arguments,
			AccessControlled accessControlled)
		throws SecurityException;

}