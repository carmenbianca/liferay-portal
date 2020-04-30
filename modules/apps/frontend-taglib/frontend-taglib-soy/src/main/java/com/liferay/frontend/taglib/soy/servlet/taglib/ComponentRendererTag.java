/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.soy.servlet.taglib;

/**
 * @author Chema Balsas
 */
public class ComponentRendererTag extends TemplateRendererTag {

	@Override
	public int doStartTag() {
		setHydrate(true);

		return super.doStartTag();
	}

}