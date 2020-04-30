/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

/**
 * @author Carlos Lancha
 */
public class DropdownRadioGroupItem extends DropdownGroupItem {

	public DropdownRadioGroupItem() {
		put("type", "radiogroup");
	}

	public void setInputName(String inputName) {
		put("inputName", inputName);
	}

}