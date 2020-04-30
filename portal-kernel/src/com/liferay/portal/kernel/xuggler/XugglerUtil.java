/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xuggler;

/**
 * @author Alexander Chow
 */
public class XugglerUtil {

	public static Xuggler getXuggler() {
		return _xuggler;
	}

	public static void installNativeLibraries(String name) throws Exception {
		getXuggler().installNativeLibraries(name);
	}

	public static boolean isEnabled() {
		return getXuggler().isEnabled();
	}

	public static boolean isEnabled(boolean checkNativeLibraries) {
		return getXuggler().isEnabled(checkNativeLibraries);
	}

	public static boolean isNativeLibraryCopied() {
		return getXuggler().isNativeLibraryCopied();
	}

	public static boolean isNativeLibraryInstalled() {
		return getXuggler().isNativeLibraryInstalled();
	}

	public void setXuggler(Xuggler xuggler) {
		_xuggler = xuggler;
	}

	private static Xuggler _xuggler;

}