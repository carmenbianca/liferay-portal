/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.base.BaseClayTag;

/**
 * @author Chema Balsas
 */
public class IconTag extends BaseClayTag {

	@Override
	public int doStartTag() {
		setComponentBaseName("ClayIcon");
		setModuleBaseName("icon");

		return super.doStartTag();
	}

	public void setMonospaced(Boolean monospaced) {
		putValue("monospaced", monospaced);
	}

	public void setSymbol(String symbol) {
		putValue("symbol", symbol);
	}

}