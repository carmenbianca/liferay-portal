/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.base.BaseClayTag;

/**
 * @author Chema Balsas
 */
public class RadioTag extends BaseClayTag {

	@Override
	public int doStartTag() {
		setComponentBaseName("ClayRadio");
		setModuleBaseName("radio");

		return super.doStartTag();
	}

	public void setChecked(Boolean checked) {
		putValue("checked", checked);
	}

	public void setDisabled(Boolean disabled) {
		putValue("disabled", disabled);
	}

	public void setInline(Boolean inline) {
		putValue("inline", inline);
	}

	public void setLabel(String label) {
		putValue("label", label);
	}

	public void setName(String name) {
		putValue("name", name);
	}

	public void setShowLabel(Boolean showLabel) {
		putValue("showLabel", showLabel);
	}

	public void setValue(String value) {
		putValue("value", value);
	}

}