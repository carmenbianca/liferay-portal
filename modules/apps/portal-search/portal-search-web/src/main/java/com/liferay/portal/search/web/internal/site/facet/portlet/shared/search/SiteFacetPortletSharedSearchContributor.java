/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.site.facet.portlet.shared.search;

import com.liferay.portal.search.facet.site.SiteFacetSearchContributor;
import com.liferay.portal.search.web.internal.site.facet.constants.SiteFacetPortletKeys;
import com.liferay.portal.search.web.internal.site.facet.portlet.SiteFacetPortletPreferences;
import com.liferay.portal.search.web.internal.site.facet.portlet.SiteFacetPortletPreferencesImpl;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchContributor;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchSettings;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author André de Oliveira
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + SiteFacetPortletKeys.SITE_FACET,
	service = PortletSharedSearchContributor.class
)
public class SiteFacetPortletSharedSearchContributor
	implements PortletSharedSearchContributor {

	@Override
	public void contribute(
		PortletSharedSearchSettings portletSharedSearchSettings) {

		SiteFacetPortletPreferences siteFacetPortletPreferences =
			new SiteFacetPortletPreferencesImpl(
				portletSharedSearchSettings.getPortletPreferencesOptional());

		siteFacetSearchContributor.contribute(
			portletSharedSearchSettings.getSearchRequestBuilder(),
			siteFacetBuilder -> siteFacetBuilder.aggregationName(
				portletSharedSearchSettings.getPortletId()
			).frequencyThreshold(
				siteFacetPortletPreferences.getFrequencyThreshold()
			).maxTerms(
				siteFacetPortletPreferences.getMaxTerms()
			).selectedGroupIds(
				portletSharedSearchSettings.getParameterValues(
					siteFacetPortletPreferences.getParameterName())
			));
	}

	@Reference
	protected SiteFacetSearchContributor siteFacetSearchContributor;

}