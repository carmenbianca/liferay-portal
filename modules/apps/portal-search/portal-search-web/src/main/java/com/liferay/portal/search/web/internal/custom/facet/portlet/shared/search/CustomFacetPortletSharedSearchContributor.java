/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.custom.facet.portlet.shared.search;

import com.liferay.portal.search.facet.custom.CustomFacetSearchContributor;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.web.internal.custom.facet.constants.CustomFacetPortletKeys;
import com.liferay.portal.search.web.internal.custom.facet.portlet.CustomFacetPortletPreferences;
import com.liferay.portal.search.web.internal.custom.facet.portlet.CustomFacetPortletPreferencesImpl;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchContributor;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchSettings;

import java.util.Optional;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Wade Cao
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + CustomFacetPortletKeys.CUSTOM_FACET,
	service = PortletSharedSearchContributor.class
)
public class CustomFacetPortletSharedSearchContributor
	implements PortletSharedSearchContributor {

	@Override
	public void contribute(
		PortletSharedSearchSettings portletSharedSearchSettings) {

		CustomFacetPortletPreferences customFacetPortletPreferences =
			new CustomFacetPortletPreferencesImpl(
				portletSharedSearchSettings.getPortletPreferencesOptional());

		SearchRequestBuilder searchRequestBuilder =
			portletSharedSearchSettings.getFederatedSearchRequestBuilder(
				customFacetPortletPreferences.getFederatedSearchKeyOptional());

		Optional<String> fieldToAggregateOptional =
			customFacetPortletPreferences.getAggregationFieldOptional();

		fieldToAggregateOptional.ifPresent(
			fieldToAggregate -> customFacetSearchContributor.contribute(
				searchRequestBuilder,
				customFacetBuilder -> customFacetBuilder.aggregationName(
					portletSharedSearchSettings.getPortletId()
				).fieldToAggregate(
					fieldToAggregate
				).frequencyThreshold(
					customFacetPortletPreferences.getFrequencyThreshold()
				).maxTerms(
					customFacetPortletPreferences.getMaxTerms()
				).selectedValues(
					portletSharedSearchSettings.getParameterValues(
						getParameterName(customFacetPortletPreferences))
				)));
	}

	protected String getParameterName(
		CustomFacetPortletPreferences customFacetPortletPreferences) {

		Optional<String> optional = Stream.of(
			customFacetPortletPreferences.getParameterNameOptional(),
			customFacetPortletPreferences.getAggregationFieldOptional()
		).filter(
			Optional::isPresent
		).map(
			Optional::get
		).findFirst();

		return optional.orElse("customfield");
	}

	@Reference
	protected CustomFacetSearchContributor customFacetSearchContributor;

}