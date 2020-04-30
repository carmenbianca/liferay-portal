/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.base.BaseClayTag;

/**
 * @author Chema Balsas
 */
public class ProgressBarTag extends BaseClayTag {

	@Override
	public int doStartTag() {
		setComponentBaseName("ClayProgressBar");
		setHydrate(true);
		setModuleBaseName("progress-bar");

		return super.doStartTag();
	}

	public void setMaxValue(int maxValue) {
		putValue("maxValue", maxValue);
	}

	public void setMinValue(int minValue) {
		putValue("minValue", minValue);
	}

	public void setStatus(String status) {
		putValue("status", status);
	}

	public void setValue(int value) {
		putValue("value", value);
	}

}