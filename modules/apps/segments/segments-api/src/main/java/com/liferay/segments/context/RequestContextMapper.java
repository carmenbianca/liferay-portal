/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.context;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Raymond Augé
 */
public interface RequestContextMapper {

	public Context map(HttpServletRequest httpServletRequest);

}