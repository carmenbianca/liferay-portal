/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.suggestions.portlet.shared.search;

import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.search.web.internal.suggestions.constants.SuggestionsPortletKeys;
import com.liferay.portal.search.web.internal.suggestions.portlet.SuggestionsPortletPreferences;
import com.liferay.portal.search.web.internal.suggestions.portlet.SuggestionsPortletPreferencesImpl;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchContributor;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + SuggestionsPortletKeys.SUGGESTIONS,
	service = PortletSharedSearchContributor.class
)
public class SuggestionsPortletSharedSearchContributor
	implements PortletSharedSearchContributor {

	@Override
	public void contribute(
		PortletSharedSearchSettings portletSharedSearchSettings) {

		SuggestionsPortletPreferences suggestionsPortletPreferences =
			new SuggestionsPortletPreferencesImpl(
				portletSharedSearchSettings.getPortletPreferencesOptional());

		setUpQueryIndexing(
			suggestionsPortletPreferences, portletSharedSearchSettings);
		setUpRelatedSuggestions(
			suggestionsPortletPreferences, portletSharedSearchSettings);
		setUpSpellCheckSuggestion(
			suggestionsPortletPreferences, portletSharedSearchSettings);
	}

	protected void setUpQueryIndexing(
		SuggestionsPortletPreferences suggestionsPortletPreferences,
		PortletSharedSearchSettings portletSharedSearchSettings) {

		QueryConfig queryConfig = portletSharedSearchSettings.getQueryConfig();

		queryConfig.setQueryIndexingEnabled(
			suggestionsPortletPreferences.isQueryIndexingEnabled());
		queryConfig.setQueryIndexingThreshold(
			suggestionsPortletPreferences.getQueryIndexingThreshold());
	}

	protected void setUpRelatedSuggestions(
		SuggestionsPortletPreferences suggestionsPortletPreferences,
		PortletSharedSearchSettings portletSharedSearchSettings) {

		QueryConfig queryConfig = portletSharedSearchSettings.getQueryConfig();

		queryConfig.setQuerySuggestionEnabled(
			suggestionsPortletPreferences.isRelatedQueriesSuggestionsEnabled());
		queryConfig.setQuerySuggestionScoresThreshold(
			suggestionsPortletPreferences.
				getRelatedQueriesSuggestionsDisplayThreshold());
		queryConfig.setQuerySuggestionMax(
			suggestionsPortletPreferences.getRelatedQueriesSuggestionsMax());
	}

	protected void setUpSpellCheckSuggestion(
		SuggestionsPortletPreferences suggestionsPortletPreferences,
		PortletSharedSearchSettings portletSharedSearchSettings) {

		QueryConfig queryConfig = portletSharedSearchSettings.getQueryConfig();

		queryConfig.setCollatedSpellCheckResultEnabled(
			suggestionsPortletPreferences.isSpellCheckSuggestionEnabled());

		queryConfig.setCollatedSpellCheckResultScoresThreshold(
			suggestionsPortletPreferences.
				getSpellCheckSuggestionDisplayThreshold());
	}

}