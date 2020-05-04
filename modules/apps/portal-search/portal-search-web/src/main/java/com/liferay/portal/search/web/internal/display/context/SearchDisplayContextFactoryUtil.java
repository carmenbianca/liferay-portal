/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.display.context;

import com.liferay.osgi.util.ServiceTrackerFactory;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Tina Tian
 */
public class SearchDisplayContextFactoryUtil {

	public static SearchDisplayContext create(
			RenderRequest renderRequest, RenderResponse renderResponse,
			PortletPreferences portletPreferences)
		throws Exception {

		SearchDisplayContextFactory searchDisplayContextFactory =
			_serviceTracker.getService();

		return searchDisplayContextFactory.create(
			renderRequest, renderResponse, portletPreferences);
	}

	private static final ServiceTracker
		<SearchDisplayContextFactory, SearchDisplayContextFactory>
			_serviceTracker = ServiceTrackerFactory.open(
				FrameworkUtil.getBundle(SearchDisplayContextFactoryUtil.class),
				SearchDisplayContextFactory.class);

}