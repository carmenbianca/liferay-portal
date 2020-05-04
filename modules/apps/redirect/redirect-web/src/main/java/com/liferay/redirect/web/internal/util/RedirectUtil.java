/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.web.internal.util;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HttpUtil;

import java.util.TreeMap;

/**
 * @author Alejandro Tardín
 */
public class RedirectUtil {

	public static String getGroupBaseURL(ThemeDisplay themeDisplay) {
		StringBuilder groupBaseURL = new StringBuilder();

		groupBaseURL.append(themeDisplay.getPortalURL());

		Group group = themeDisplay.getScopeGroup();

		LayoutSet layoutSet = group.getPublicLayoutSet();

		TreeMap<String, String> virtualHostnames =
			layoutSet.getVirtualHostnames();

		if (virtualHostnames.isEmpty() ||
			!_matchesHostname(groupBaseURL, virtualHostnames)) {

			groupBaseURL.append(group.getPathFriendlyURL(false, themeDisplay));
			groupBaseURL.append(HttpUtil.decodeURL(group.getFriendlyURL()));
		}

		return groupBaseURL.toString();
	}

	private static boolean _matchesHostname(
		StringBuilder friendlyURLBase,
		TreeMap<String, String> virtualHostnames) {

		for (String virtualHostname : virtualHostnames.keySet()) {
			if (friendlyURLBase.indexOf(virtualHostname) != -1) {
				return true;
			}
		}

		return false;
	}

}