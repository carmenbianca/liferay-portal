/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

/**
 * @author Carlos Lancha
 */
public class DropdownRadioItem extends DropdownItem {

	public DropdownRadioItem() {
		put("type", "radio");
	}

	public void setChecked(boolean checked) {
		put("checked", checked);
	}

	public void setInputValue(String inputValue) {
		put("inputValue", inputValue);
	}

}