/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xuggler;

/**
 * @author Alexander Chow
 */
public interface Xuggler {

	public void installNativeLibraries(String name) throws Exception;

	public boolean isEnabled();

	public boolean isEnabled(boolean checkNativeLibraries);

	public boolean isNativeLibraryCopied();

	public boolean isNativeLibraryInstalled();

}