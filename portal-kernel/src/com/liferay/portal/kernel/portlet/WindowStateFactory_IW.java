/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

/**
 * @author Brian Wing Shun Chan
 */
public class WindowStateFactory_IW {
	public static WindowStateFactory_IW getInstance() {
		return _instance;
	}

	public javax.portlet.WindowState getWindowState(java.lang.String name) {
		return WindowStateFactory.getWindowState(name);
	}

	public javax.portlet.WindowState getWindowState(java.lang.String name,
		int portletMajorVersion) {
		return WindowStateFactory.getWindowState(name, portletMajorVersion);
	}

	private WindowStateFactory_IW() {
	}

	private static WindowStateFactory_IW _instance = new WindowStateFactory_IW();
}