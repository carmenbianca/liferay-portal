/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.info.display.contributor.util;

/**
 * @author Pavel Savinov
 */
public class ContentAccessorUtil {

	public static ContentAccessorUtil getInstance() {
		return _contentAccessorUtil;
	}

	public static boolean isContentAccessor(Object object) {
		return object instanceof ContentAccessor;
	}

	private ContentAccessorUtil() {
	}

	private static ContentAccessorUtil _contentAccessorUtil =
		new ContentAccessorUtil();

}