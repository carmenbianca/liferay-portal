/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.internal.canonical.url;

import com.liferay.layout.seo.canonical.url.LayoutSEOCanonicalURLProvider;
import com.liferay.layout.seo.internal.configuration.LayoutSEOCompanyConfiguration;
import com.liferay.layout.seo.model.LayoutSEOEntry;
import com.liferay.layout.seo.service.LayoutSEOEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(service = LayoutSEOCanonicalURLProvider.class)
public class LayoutSEOCanonicalURLProviderImpl
	implements LayoutSEOCanonicalURLProvider {

	@Override
	public String getCanonicalURL(
			Layout layout, Locale locale, String canonicalURL,
			Map<Locale, String> alternateURLs)
		throws PortalException {

		String layoutCanonicalURL = _getLayoutCanonicalURL(locale, layout);

		if (Validator.isNotNull(layoutCanonicalURL)) {
			return layoutCanonicalURL;
		}

		return _getDefaultCanonicalURL(
			layout, locale, canonicalURL, alternateURLs);
	}

	@Override
	public Map<Locale, String> getCanonicalURLMap(
			Layout layout, ThemeDisplay themeDisplay)
		throws PortalException {

		String canonicalURL = _portal.getCanonicalURL(
			_portal.getLayoutFullURL(layout, themeDisplay), themeDisplay,
			layout, false, false);

		Map<Locale, String> alternateURLs = _portal.getAlternateURLs(
			canonicalURL, themeDisplay, layout);

		LayoutSEOEntry layoutSEOEntry =
			_layoutSEOEntryLocalService.fetchLayoutSEOEntry(
				layout.getGroupId(), layout.isPrivateLayout(),
				layout.getLayoutId());

		if ((layoutSEOEntry == null) ||
			!layoutSEOEntry.isCanonicalURLEnabled()) {

			return alternateURLs;
		}

		Map<Locale, String> canonicalURLMap = new HashMap<>(alternateURLs);

		canonicalURLMap.putAll(layoutSEOEntry.getCanonicalURLMap());

		return canonicalURLMap;
	}

	@Override
	public String getDefaultCanonicalURL(
			Layout layout, ThemeDisplay themeDisplay)
		throws PortalException {

		String canonicalURL = _portal.getCanonicalURL(
			_portal.getLayoutFullURL(layout, themeDisplay), themeDisplay,
			layout, false, false);

		return _getDefaultCanonicalURL(
			layout, themeDisplay.getLocale(), canonicalURL,
			_portal.getAlternateURLs(canonicalURL, themeDisplay, layout));
	}

	private String _getDefaultCanonicalURL(
			Layout layout, Locale locale, String canonicalURL,
			Map<Locale, String> alternateURLs)
		throws PortalException {

		LayoutSEOCompanyConfiguration layoutSEOCompanyConfiguration =
			_configurationProvider.getCompanyConfiguration(
				LayoutSEOCompanyConfiguration.class, layout.getCompanyId());

		if (Objects.equals(
				layoutSEOCompanyConfiguration.canonicalURL(),
				"default-language-url")) {

			return canonicalURL;
		}

		return alternateURLs.getOrDefault(locale, canonicalURL);
	}

	private String _getLayoutCanonicalURL(Locale locale, Layout layout) {
		LayoutSEOEntry layoutSEOEntry =
			_layoutSEOEntryLocalService.fetchLayoutSEOEntry(
				layout.getGroupId(), layout.isPrivateLayout(),
				layout.getLayoutId());

		if ((layoutSEOEntry == null) ||
			!layoutSEOEntry.isCanonicalURLEnabled()) {

			return StringPool.BLANK;
		}

		return layoutSEOEntry.getCanonicalURL(locale);
	}

	@Reference
	private ConfigurationProvider _configurationProvider;

	@Reference
	private Http _http;

	@Reference
	private LayoutSEOEntryLocalService _layoutSEOEntryLocalService;

	@Reference
	private Portal _portal;

}