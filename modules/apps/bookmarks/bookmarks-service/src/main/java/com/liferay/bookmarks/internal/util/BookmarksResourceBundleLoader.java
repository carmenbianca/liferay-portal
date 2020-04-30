/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.util;

import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

/**
 * @author Adolfo Pérez
 */
public class BookmarksResourceBundleLoader extends ClassResourceBundleLoader {

	public static final ResourceBundleLoader INSTANCE =
		new BookmarksResourceBundleLoader();

	protected BookmarksResourceBundleLoader() {
		super("content.Language", BookmarksResourceBundleLoader.class);
	}

}