/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import javax.portlet.PortletMode;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferayPortletMode extends PortletMode {

	public static final PortletMode ABOUT = new PortletMode("about");

	public static final PortletMode CONFIG = new PortletMode("config");

	public static final PortletMode EDIT_DEFAULTS = new PortletMode(
		"edit_defaults");

	public static final PortletMode EDIT_GUEST = new PortletMode("edit_guest");

	public static final PortletMode PREVIEW = new PortletMode("preview");

	public static final PortletMode PRINT = new PortletMode("print");

	public LiferayPortletMode(String name) {
		super(name);
	}

}