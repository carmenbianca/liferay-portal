/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

/**
 * @author Carlos Lancha
 */
public class DropdownItem extends NavigationItem {

	public DropdownItem() {
		put("type", "item");
	}

	public void setIcon(String icon) {
		put("icon", icon);
	}

	public void setQuickAction(boolean quickAction) {
		put("quickAction", quickAction);
	}

	public void setSeparator(boolean separator) {
		put("separator", separator);
	}

	public void setTarget(String target) {
		put("target", target);
	}

}