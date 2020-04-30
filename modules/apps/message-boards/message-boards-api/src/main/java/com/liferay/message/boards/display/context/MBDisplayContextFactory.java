/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.display.context;

import com.liferay.portal.kernel.display.context.DisplayContextFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Iván Zaera
 */
public interface MBDisplayContextFactory extends DisplayContextFactory {

	public MBAdminListDisplayContext getMBAdminListDisplayContext(
		MBAdminListDisplayContext parentMBAdminListDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, long categoryId);

	public MBHomeDisplayContext getMBHomeDisplayContext(
		MBHomeDisplayContext parentMBHomeDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse);

	public MBListDisplayContext getMBListDisplayContext(
		MBListDisplayContext parentMBListDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, long categoryId);

}