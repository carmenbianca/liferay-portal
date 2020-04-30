/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.audit.event.generators.constants;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public interface EventTypes {

	public static final String ADD = "ADD";

	public static final String ASSIGN = "ASSIGN";

	public static final String DELETE = "DELETE";

	public static final String IMPERSONATE = "IMPERSONATE";

	public static final String LOGIN = "LOGIN";

	public static final String LOGIN_FAILURE = "LOGIN_FAILURE";

	public static final String LOGOUT = "LOGOUT";

	public static final String UNASSIGN = "UNASSIGN";

	public static final String UPDATE = "UPDATE";

}