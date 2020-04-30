/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

/**
 * Contains constants used for resource permissions and permission scoping.
 *
 * @author Brian Wing Shun Chan
 */
public interface ResourceConstants {

	public static final long PRIMKEY_DNE = -1;

	public static final int SCOPE_COMPANY = 1;

	public static final int SCOPE_GROUP = 2;

	public static final int SCOPE_GROUP_TEMPLATE = 3;

	public static final int SCOPE_INDIVIDUAL = 4;

	public static final int[] SCOPES = {
		SCOPE_COMPANY, SCOPE_GROUP, SCOPE_GROUP_TEMPLATE, SCOPE_INDIVIDUAL
	};

}