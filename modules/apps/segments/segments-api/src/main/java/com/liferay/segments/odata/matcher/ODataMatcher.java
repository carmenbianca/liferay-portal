/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.odata.matcher;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public interface ODataMatcher<T> {

	public boolean matches(String filterString, T pattern)
		throws PortalException;

}