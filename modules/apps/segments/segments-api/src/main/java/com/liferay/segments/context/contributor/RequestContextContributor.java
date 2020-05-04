/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.context.contributor;

import com.liferay.segments.context.Context;

import javax.servlet.http.HttpServletRequest;

/**
 * Provides an interface for extending the {@link Context} with information from
 * the request.
 *
 * @author Eduardo García
 */
public interface RequestContextContributor {

	/**
	 * Contributes additional information to the context.
	 *
	 * @param context the context that segments users
	 * @param httpServletRequest the current request
	 */
	public void contribute(
		Context context, HttpServletRequest httpServletRequest);

}