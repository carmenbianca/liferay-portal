/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

import java.util.List;

/**
 * @author Carlos Lancha
 */
public class DropdownGroupItem extends DropdownItem {

	public DropdownGroupItem() {
		put("type", "group");
	}

	public void setDropdownItems(List<DropdownItem> dropdownItems) {
		put("items", dropdownItems);
	}

}