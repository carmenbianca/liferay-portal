/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layouts.admin.kernel.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.xml.Element;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author     Raymond Augé
 * @deprecated As of Mueller (7.2.x), replaced by {@link
 *             com.liferay.layout.admin.kernel.util.SitemapUtil}
 */
@Deprecated
public class SitemapUtil {

	public static void addURLElement(
		Element element, String url,
		UnicodeProperties typeSettingsUnicodeProperties, Date modifiedDate,
		String canonicalURL, Map<Locale, String> alternateURLs) {

		getSitemap().addURLElement(
			element, url, typeSettingsUnicodeProperties, modifiedDate,
			canonicalURL, alternateURLs);
	}

	public static String encodeXML(String input) {
		return getSitemap().encodeXML(input);
	}

	public static Map<Locale, String> getAlternateURLs(
			String canonicalURL, ThemeDisplay themeDisplay, Layout layout)
		throws PortalException {

		return getSitemap().getAlternateURLs(
			canonicalURL, themeDisplay, layout);
	}

	public static Sitemap getSitemap() {
		return _sitemap;
	}

	public static String getSitemap(
			long groupId, boolean privateLayout, ThemeDisplay themeDisplay)
		throws PortalException {

		return getSitemap().getSitemap(groupId, privateLayout, themeDisplay);
	}

	public static String getSitemap(
			String layoutUuid, long groupId, boolean privateLayout,
			ThemeDisplay themeDisplay)
		throws PortalException {

		return getSitemap().getSitemap(
			layoutUuid, groupId, privateLayout, themeDisplay);
	}

	public void setSitemap(Sitemap sitemap) {
		_sitemap = sitemap;
	}

	private static Sitemap _sitemap;

}