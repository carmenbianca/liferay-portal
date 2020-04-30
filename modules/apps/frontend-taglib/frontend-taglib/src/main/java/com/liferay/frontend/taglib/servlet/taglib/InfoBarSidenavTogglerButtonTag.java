/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.servlet.taglib;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Roberto Díaz
 */
public class InfoBarSidenavTogglerButtonTag
	extends ManagementBarSidenavTogglerButtonTag {

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		setCssClass("btn-secondary " + getCssClass());

		super.setAttributes(httpServletRequest);
	}

}