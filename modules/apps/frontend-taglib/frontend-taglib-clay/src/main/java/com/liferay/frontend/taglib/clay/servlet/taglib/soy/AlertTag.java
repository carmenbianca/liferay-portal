/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.base.BaseClayTag;

/**
 * @author Carlos Lancha
 */
public class AlertTag extends BaseClayTag {

	@Override
	public int doStartTag() {
		setComponentBaseName("ClayAlert");
		setHydrate(true);
		setModuleBaseName("alert");

		return super.doStartTag();
	}

	public void setAutoclose(Boolean autoClose) {
		putValue("autoClose", autoClose);
	}

	public void setCloseable(Boolean closeable) {
		putValue("closeable", closeable);
	}

	public void setDestroyOnHide(Boolean destroyOnHide) {
		putValue("destroyOnHide", destroyOnHide);
	}

	public void setMessage(String message) {
		putValue("message", message);
	}

	public void setStyle(String style) {
		putValue("style", style);
	}

	public void setTitle(String title) {
		putValue("title", title);
	}

	public void setType(String type) {
		putValue("type", type);
	}

}