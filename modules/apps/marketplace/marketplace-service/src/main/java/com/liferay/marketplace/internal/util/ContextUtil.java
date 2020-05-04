/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.internal.util;

import com.liferay.petra.string.StringPool;

/**
 * @author Joan Kim
 */
public class ContextUtil {

	public static String getContextName(String contextPath) {
		String contextName = contextPath;

		if (contextName.length() == 0) {
			return StringPool.BLANK;
		}

		if (contextName.startsWith(StringPool.FORWARD_SLASH)) {
			contextName = contextName.substring(1);
		}

		if (contextName.endsWith(StringPool.FORWARD_SLASH)) {
			contextName = contextName.substring(0, contextName.length() - 1);
		}

		int index = getPluginTypeIndex(contextName);

		if (index >= 0) {
			contextName = contextName.substring(0, index);
		}

		return contextName;
	}

	protected static int getPluginTypeIndex(String contextName) {
		for (String pluginType : _PLUGIN_TYPES) {
			int index = contextName.lastIndexOf(pluginType);

			if (index >= 0) {
				return index + pluginType.length();
			}
		}

		return -1;
	}

	private static final String[] _PLUGIN_TYPES = {
		"-ext", "-hook", "-layouttpl", "-portlet", "-theme", "-web"
	};

}