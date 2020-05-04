/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.usersadmin.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.users.admin.kernel.util.UsersAdminUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationSearch extends SearchContainer<Organization> {

	public static final String EMPTY_RESULTS_MESSAGE =
		"no-organizations-were-found";

	public static List<String> headerNames = new ArrayList<String>() {
		{
			add("name");
			add("parent-organization");
			add("type");
			add("city");
			add("region");
			add("country");
		}
	};
	public static Map<String, String> orderableHeaders = HashMapBuilder.put(
		"name", "name"
	).put(
		"type", "type"
	).build();

	public OrganizationSearch(
		PortletRequest portletRequest, PortletURL iteratorURL) {

		this(portletRequest, DEFAULT_CUR_PARAM, iteratorURL);
	}

	public OrganizationSearch(
		PortletRequest portletRequest, String curParam,
		PortletURL iteratorURL) {

		super(
			portletRequest, new OrganizationDisplayTerms(portletRequest),
			new OrganizationSearchTerms(portletRequest), curParam,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		OrganizationDisplayTerms displayTerms =
			(OrganizationDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
			OrganizationDisplayTerms.CITY, displayTerms.getCity());
		iteratorURL.setParameter(
			OrganizationDisplayTerms.COUNTRY_ID,
			String.valueOf(displayTerms.getCountryId()));
		iteratorURL.setParameter(
			OrganizationDisplayTerms.NAME, displayTerms.getName());
		iteratorURL.setParameter(
			OrganizationDisplayTerms.PARENT_ORGANIZATION_ID,
			String.valueOf(displayTerms.getParentOrganizationId()));
		iteratorURL.setParameter(
			OrganizationDisplayTerms.REGION_ID,
			String.valueOf(displayTerms.getRegionId()));
		iteratorURL.setParameter(
			OrganizationDisplayTerms.STREET, displayTerms.getStreet());
		iteratorURL.setParameter(
			OrganizationDisplayTerms.TYPE, displayTerms.getType());
		iteratorURL.setParameter(
			OrganizationDisplayTerms.ZIP, displayTerms.getZip());

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					portletRequest);

			String portletId = PortletProviderUtil.getPortletId(
				User.class.getName(), PortletProvider.Action.VIEW);

			String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
					portletId, "organizations-order-by-col", orderByCol);
				preferences.setValue(
					portletId, "organizations-order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(
					portletId, "organizations-order-by-col", "name");
				orderByType = preferences.getValue(
					portletId, "organizations-order-by-type", "asc");
			}

			OrderByComparator<Organization> orderByComparator =
				UsersAdminUtil.getOrganizationOrderByComparator(
					orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception exception) {
			_log.error("Unable to initialize organization search", exception);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		OrganizationSearch.class);

}