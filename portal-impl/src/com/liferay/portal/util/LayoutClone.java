/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public interface LayoutClone {

	public String get(HttpServletRequest httpServletRequest, long plid);

	public void update(
		HttpServletRequest httpServletRequest, long plid, String typeSettings);

}