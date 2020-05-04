/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.util;

import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;

/**
 * @author Adolfo Pérez
 */
public class JournalResourceBundleLoader extends ClassResourceBundleLoader {

	public static final ResourceBundleLoader INSTANCE =
		new AggregateResourceBundleLoader(
			new JournalResourceBundleLoader(),
			ResourceBundleLoaderUtil.getPortalResourceBundleLoader());

	protected JournalResourceBundleLoader() {
		super("content.Language", JournalResourceBundleLoader.class);
	}

}