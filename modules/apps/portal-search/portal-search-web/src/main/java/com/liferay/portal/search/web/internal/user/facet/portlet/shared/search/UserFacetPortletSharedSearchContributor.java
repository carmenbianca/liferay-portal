/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.user.facet.portlet.shared.search;

import com.liferay.portal.search.facet.user.UserFacetSearchContributor;
import com.liferay.portal.search.web.internal.user.facet.constants.UserFacetPortletKeys;
import com.liferay.portal.search.web.internal.user.facet.portlet.UserFacetPortletPreferences;
import com.liferay.portal.search.web.internal.user.facet.portlet.UserFacetPortletPreferencesImpl;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchContributor;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchSettings;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lino Alves
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + UserFacetPortletKeys.USER_FACET,
	service = PortletSharedSearchContributor.class
)
public class UserFacetPortletSharedSearchContributor
	implements PortletSharedSearchContributor {

	@Override
	public void contribute(
		PortletSharedSearchSettings portletSharedSearchSettings) {

		UserFacetPortletPreferences userFacetPortletPreferences =
			new UserFacetPortletPreferencesImpl(
				portletSharedSearchSettings.getPortletPreferencesOptional());

		userFacetSearchContributor.contribute(
			portletSharedSearchSettings.getSearchRequestBuilder(),
			userFacetBuilder -> userFacetBuilder.aggregationName(
				portletSharedSearchSettings.getPortletId()
			).frequencyThreshold(
				userFacetPortletPreferences.getFrequencyThreshold()
			).maxTerms(
				userFacetPortletPreferences.getMaxTerms()
			).selectedUserNames(
				portletSharedSearchSettings.getParameterValues(
					userFacetPortletPreferences.getParameterName())
			));
	}

	@Reference
	protected UserFacetSearchContributor userFacetSearchContributor;

}