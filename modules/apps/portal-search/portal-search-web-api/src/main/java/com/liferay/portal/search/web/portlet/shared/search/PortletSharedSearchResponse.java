/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.portlet.shared.search;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.web.search.request.SearchSettings;

import java.util.List;
import java.util.Optional;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface PortletSharedSearchResponse {

	public List<Document> getDocuments();

	public Facet getFacet(String name);

	public SearchResponse getFederatedSearchResponse(
		Optional<String> federatedSearchKeyOptional);

	public Optional<String> getKeywordsOptional();

	public int getPaginationDelta();

	public int getPaginationStart();

	public Optional<String> getParameter(
		String name, RenderRequest renderRequest);

	public Optional<String[]> getParameterValues(
		String name, RenderRequest renderRequest);

	public Optional<PortletPreferences> getPortletPreferences(
		RenderRequest renderRequest);

	public List<String> getRelatedQueriesSuggestions();

	/**
	 * Returns the search response shared by the portlets.
	 *
	 * @return the search response as processed by the Liferay Search Framework
	 */
	public SearchResponse getSearchResponse();

	public SearchSettings getSearchSettings();

	public Optional<String> getSpellCheckSuggestionOptional();

	public ThemeDisplay getThemeDisplay(RenderRequest renderRequest);

	/**
	 * @deprecated As of Mueller (7.2.x), replaced by {@link
	 *             #getSearchResponse()} and {@link
	 *             SearchResponse#getTotalHits()}
	 */
	@Deprecated
	public int getTotalHits();

}