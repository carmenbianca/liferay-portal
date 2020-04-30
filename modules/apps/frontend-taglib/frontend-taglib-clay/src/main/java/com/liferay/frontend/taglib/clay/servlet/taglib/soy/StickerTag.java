/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.base.BaseClayTag;

/**
 * @author Carlos Lancha
 */
public class StickerTag extends BaseClayTag {

	@Override
	public int doStartTag() {
		setComponentBaseName("ClaySticker");
		setModuleBaseName("sticker");

		return super.doStartTag();
	}

	public void setIcon(String icon) {
		putValue("icon", icon);
	}

	public void setLabel(String label) {
		putValue("label", label);
	}

	public void setOutside(Boolean outside) {
		putValue("outside", outside);
	}

	public void setPosition(String position) {
		putValue("position", position);
	}

	public void setShape(String shape) {
		putValue("shape", shape);
	}

	public void setSize(String size) {
		putValue("size", size);
	}

	public void setStyle(String style) {
		putValue("style", style);
	}

}