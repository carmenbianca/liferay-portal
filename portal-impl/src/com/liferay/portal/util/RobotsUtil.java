/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util;

import com.liferay.petra.content.ContentUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.TreeMap;

/**
 * @author David Truong
 * @author Jesse Rao
 */
public class RobotsUtil {

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static String getDefaultRobots() {
		int portalServerPort = PortalUtil.getPortalServerPort(false);

		return getDefaultRobots(null, false, portalServerPort);
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static String getDefaultRobots(
		String virtualHostname, boolean secure, int port) {

		if (Validator.isNotNull(virtualHostname)) {
			return ContentUtil.get(
				RobotsUtil.class.getClassLoader(),
				PropsValues.ROBOTS_TXT_WITH_SITEMAP);
		}

		return ContentUtil.get(
			RobotsUtil.class.getClassLoader(),
			PropsValues.ROBOTS_TXT_WITHOUT_SITEMAP);
	}

	public static String getRobots(LayoutSet layoutSet, boolean secure)
		throws PortalException {

		if (layoutSet == null) {
			return ContentUtil.get(
				RobotsUtil.class.getClassLoader(),
				PropsValues.ROBOTS_TXT_WITHOUT_SITEMAP);
		}

		int portalServerPort = PortalUtil.getPortalServerPort(secure);

		TreeMap<String, String> virtualHostnames =
			PortalUtil.getVirtualHostnames(layoutSet);

		String virtualHostname = StringPool.BLANK;

		if (!virtualHostnames.isEmpty()) {
			virtualHostname = virtualHostnames.firstKey();
		}

		String robotsTxt = GetterUtil.getString(
			layoutSet.getSettingsProperty(
				layoutSet.isPrivateLayout() + "-robots.txt"),
			ContentUtil.get(
				RobotsUtil.class.getClassLoader(),
				PropsValues.ROBOTS_TXT_WITH_SITEMAP));

		return _replaceWildcards(
			robotsTxt, virtualHostname, secure, portalServerPort);
	}

	private static String _replaceWildcards(
		String robotsTxt, String virtualHostname, boolean secure, int port) {

		if (Validator.isNotNull(virtualHostname)) {
			robotsTxt = StringUtil.replace(
				robotsTxt, "[$HOST$]", virtualHostname);
		}
		else if (_log.isWarnEnabled()) {
			_log.warn(
				"Placeholder [$HOST$] could not be replaced with the actual " +
					"host");
		}

		robotsTxt = StringUtil.replace(
			robotsTxt, "[$PORT$]", String.valueOf(port));

		if (secure) {
			return StringUtil.replace(robotsTxt, "[$PROTOCOL$]", "https");
		}

		return StringUtil.replace(robotsTxt, "[$PROTOCOL$]", "http");
	}

	private static final Log _log = LogFactoryUtil.getLog(RobotsUtil.class);

}