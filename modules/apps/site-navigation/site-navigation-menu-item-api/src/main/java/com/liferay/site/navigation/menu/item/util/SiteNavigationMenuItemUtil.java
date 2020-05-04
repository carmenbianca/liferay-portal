/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.menu.item.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.site.navigation.menu.item.layout.constants.SiteNavigationMenuItemTypeConstants;
import com.liferay.site.navigation.model.SiteNavigationMenuItem;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.portlet.PortletRequest;

/**
 * @author Pavel Savinov
 */
public class SiteNavigationMenuItemUtil {

	public static UnicodeProperties getSiteNavigationMenuItemProperties(
		PortletRequest portletRequest, String prefix) {

		Map<String, String[]> parameterMap = portletRequest.getParameterMap();

		String[] localizableParameters = {};

		for (String key : parameterMap.keySet()) {
			if (key.startsWith(prefix)) {
				continue;
			}

			localizableParameters = ArrayUtil.append(
				localizableParameters, key);
		}

		UnicodeProperties unicodeProperties = PropertiesParamUtil.getProperties(
			portletRequest, prefix);

		for (String localizableParameter : localizableParameters) {
			Map<Locale, String> map = LocalizationUtil.getLocalizationMap(
				portletRequest, localizableParameter);

			if (MapUtil.isEmpty(map)) {
				continue;
			}

			for (Map.Entry<Locale, String> entry : map.entrySet()) {
				String value = entry.getValue();

				if (Validator.isNull(value)) {
					continue;
				}

				String key =
					localizableParameter + "_" +
						LocaleUtil.toLanguageId(entry.getKey());

				unicodeProperties.setProperty(key, value);
			}
		}

		if (!unicodeProperties.containsKey(Field.DEFAULT_LANGUAGE_ID)) {
			unicodeProperties.setProperty(
				Field.DEFAULT_LANGUAGE_ID,
				LocaleUtil.toLanguageId(LocaleUtil.getMostRelevantLocale()));
		}

		return unicodeProperties;
	}

	public static String getSiteNavigationMenuItemXML(
			SiteNavigationMenuItem siteNavigationMenuItem, String name)
		throws PortalException {

		if (siteNavigationMenuItem == null) {
			return StringPool.BLANK;
		}

		UnicodeProperties typeSettingsUnicodeProperties =
			new UnicodeProperties();

		typeSettingsUnicodeProperties.fastLoad(
			siteNavigationMenuItem.getTypeSettings());

		Set<Locale> availableLocales = LanguageUtil.getAvailableLocales(
			siteNavigationMenuItem.getGroupId());

		if (Objects.equals(
				siteNavigationMenuItem.getType(),
				SiteNavigationMenuItemTypeConstants.LAYOUT)) {

			String layoutUuid = typeSettingsUnicodeProperties.get("layoutUuid");

			boolean privateLayout = GetterUtil.getBoolean(
				typeSettingsUnicodeProperties.get("privateLayout"));

			Layout layout = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(
				layoutUuid, siteNavigationMenuItem.getGroupId(), privateLayout);

			Map<Locale, String> nameMap = layout.getNameMap();

			for (Map.Entry<Locale, String> nameEntry : nameMap.entrySet()) {
				String languageId = LocaleUtil.toLanguageId(nameEntry.getKey());
				String value = nameEntry.getValue();

				if (Validator.isNull(
						typeSettingsUnicodeProperties.getProperty(
							"name_" + languageId))) {

					typeSettingsUnicodeProperties.setProperty(
						"name_" + languageId, value);
				}
			}
		}

		Stream<Locale> stream = availableLocales.stream();

		Map<String, String> map = stream.map(
			locale -> LocaleUtil.toLanguageId(locale)
		).filter(
			languageId -> Validator.isNotNull(
				typeSettingsUnicodeProperties.getProperty(
					name + "_" + languageId))
		).collect(
			Collectors.toMap(
				languageId -> languageId,
				languageId -> typeSettingsUnicodeProperties.getProperty(
					name + "_" + languageId))
		);

		if (MapUtil.isEmpty(map)) {
			String defaultLanguageId =
				typeSettingsUnicodeProperties.getProperty(
					Field.DEFAULT_LANGUAGE_ID,
					LocaleUtil.toLanguageId(
						PortalUtil.getSiteDefaultLocale(
							siteNavigationMenuItem.getGroupId())));

			map.put(
				defaultLanguageId,
				GetterUtil.getString(
					typeSettingsUnicodeProperties.getProperty(name)));
		}

		return LocalizationUtil.getXml(
			map, LocaleUtil.toLanguageId(LocaleUtil.getMostRelevantLocale()),
			name);
	}

}