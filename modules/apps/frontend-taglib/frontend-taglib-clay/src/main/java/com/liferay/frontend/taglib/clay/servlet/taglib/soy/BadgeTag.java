/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.base.BaseClayTag;

/**
 * @author Carlos Lancha
 */
public class BadgeTag extends BaseClayTag {

	@Override
	public int doStartTag() {
		setComponentBaseName("ClayBadge");
		setModuleBaseName("badge");

		return super.doStartTag();
	}

	public void setLabel(String label) {
		putValue("label", label);
	}

	public void setStyle(String style) {
		putValue("style", style);
	}

}