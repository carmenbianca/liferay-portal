/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.base.BaseClayTag;

/**
 * @author Chema Balsas
 */
public class LabelTag extends BaseClayTag {

	@Override
	public int doStartTag() {
		setComponentBaseName("ClayLabel");
		setModuleBaseName("label");

		return super.doStartTag();
	}

	public void setCloseable(Boolean closeable) {
		putValue("closeable", closeable);
	}

	public void setHref(String href) {
		putValue("href", href);
	}

	public void setLabel(String label) {
		putValue("label", label);
	}

	public void setMessage(String message) {
		putValue("message", message);
	}

	public void setSize(String size) {
		putValue("size", size);
	}

	public void setStyle(String style) {
		putValue("style", style);
	}

}