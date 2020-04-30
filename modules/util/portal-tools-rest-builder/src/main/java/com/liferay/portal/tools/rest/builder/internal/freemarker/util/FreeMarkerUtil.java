/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.rest.builder.internal.freemarker.util;

import com.liferay.portal.tools.rest.builder.internal.freemarker.FreeMarker;

import java.io.File;

import java.util.Map;

/**
 * @author Peter Shin
 */
public class FreeMarkerUtil {

	public static String processTemplate(
			File copyrightFile, String name, Map<String, Object> context)
		throws Exception {

		return _freeMarker.processTemplate(
			copyrightFile,
			"com/liferay/portal/tools/rest/builder/dependencies/" + name +
				".ftl",
			context);
	}

	private static final FreeMarker _freeMarker = new FreeMarker();

}