/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.sort.portlet.shared.search;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.sort.Sort;
import com.liferay.portal.search.sort.SortBuilder;
import com.liferay.portal.search.sort.SortBuilderFactory;
import com.liferay.portal.search.sort.SortOrder;
import com.liferay.portal.search.web.internal.sort.constants.SortPortletKeys;
import com.liferay.portal.search.web.internal.sort.portlet.SortPortletPreferences;
import com.liferay.portal.search.web.internal.sort.portlet.SortPortletPreferencesImpl;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchContributor;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchSettings;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Wade Cao
 */
@Component(
	immediate = true, property = "javax.portlet.name=" + SortPortletKeys.SORT,
	service = PortletSharedSearchContributor.class
)
public class SortPortletSharedSearchContributor
	implements PortletSharedSearchContributor {

	@Override
	public void contribute(
		PortletSharedSearchSettings portletSharedSearchSettings) {

		SortPortletPreferences sortPortletPreferences =
			new SortPortletPreferencesImpl(
				portletSharedSearchSettings.getPortletPreferencesOptional());

		SearchRequestBuilder searchRequestBuilder =
			portletSharedSearchSettings.getSearchRequestBuilder();

		Stream<Sort> stream = buildSorts(
			portletSharedSearchSettings, sortPortletPreferences);

		searchRequestBuilder.sorts(stream.toArray(Sort[]::new));
	}

	protected Sort buildSort(String fieldValue, Locale locale) {
		SortBuilder sortBuilder = _sortBuilderFactory.getSortBuilder();

		if (fieldValue.endsWith("+")) {
			sortBuilder.field(fieldValue.substring(0, fieldValue.length() - 1));
		}
		else if (fieldValue.endsWith("-")) {
			sortBuilder.field(
				fieldValue.substring(0, fieldValue.length() - 1)
			).sortOrder(
				SortOrder.DESC
			);
		}
		else {
			sortBuilder.field(fieldValue);
		}

		return sortBuilder.locale(
			locale
		).build();
	}

	protected Stream<Sort> buildSorts(
		PortletSharedSearchSettings portletSharedSearchSettings,
		SortPortletPreferences sortPortletPreferences) {

		List<String> fieldValues = Arrays.asList(
			portletSharedSearchSettings.getParameterValues(
				sortPortletPreferences.getParameterName()));

		ThemeDisplay themeDisplay =
			portletSharedSearchSettings.getThemeDisplay();

		Stream<String> stream = fieldValues.stream();

		return stream.filter(
			fieldValue -> !fieldValue.isEmpty()
		).map(
			fieldValue -> buildSort(fieldValue, themeDisplay.getLocale())
		);
	}

	@Reference
	private SortBuilderFactory _sortBuilderFactory;

}