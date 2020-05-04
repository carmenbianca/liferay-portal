/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.search.bar.portlet.provider;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;
import com.liferay.portal.search.web.constants.SearchBarPortletKeys;
import com.liferay.portal.search.web.constants.SearchPortletKeys;
import com.liferay.portal.search.web.internal.configuration.SearchWebConfiguration;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Adam Brandizzi
 */
@Component(
	configurationPid = "com.liferay.portal.search.web.internal.configuration.SearchWebConfiguration",
	immediate = true,
	property = "model.class.name=" + SearchBarPortletKeys.SEARCH_BAR,
	service = ViewPortletProvider.class
)
public class SearchBarViewPortletProvider
	extends BasePortletProvider implements ViewPortletProvider {

	@Override
	public String getPortletName() {
		if (_classicSearchPortletInFrontPage) {
			return SearchPortletKeys.SEARCH;
		}

		return SearchBarPortletKeys.SEARCH_BAR;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		SearchWebConfiguration searchWebConfiguration =
			ConfigurableUtil.createConfigurable(
				SearchWebConfiguration.class, properties);

		_classicSearchPortletInFrontPage =
			searchWebConfiguration.classicSearchPortletInFrontPage();
	}

	private volatile boolean _classicSearchPortletInFrontPage;

}