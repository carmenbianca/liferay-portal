/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.wab.extender.internal;

import com.liferay.petra.string.StringPool;

import java.util.Dictionary;

import org.osgi.framework.Bundle;

/**
 * @author Raymond Augé
 */
public class WabUtil {

	public static String getWebContextPath(Bundle bundle) {
		Dictionary<String, String> headers = bundle.getHeaders(
			StringPool.BLANK);

		return headers.get("Web-ContextPath");
	}

}