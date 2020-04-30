/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.base.BaseClayTag;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;

import java.util.List;

/**
 * @author Chema Balsas
 */
public class NavigationBarTag extends BaseClayTag {

	@Override
	public int doStartTag() {
		setComponentBaseName("ClayNavigationBar");
		setHydrate(true);
		setModuleBaseName("navigation-bar");

		return super.doStartTag();
	}

	public void setInverted(Boolean inverted) {
		putValue("inverted", inverted);
	}

	public void setNavigationItems(List<NavigationItem> navigationItems) {
		putValue("items", navigationItems);
	}

}