/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.portletconfiguration.util;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.filter.ResourceRequestWrapper;

/**
 * @author Raymond Augé
 */
public class ConfigurationResourceRequest
	extends ResourceRequestWrapper implements ConfigurationPortletRequest {

	public ConfigurationResourceRequest(
		ResourceRequest resourceRequest,
		PortletPreferences portletPreferences) {

		super(resourceRequest);

		_portletPreferences = portletPreferences;
	}

	@Override
	public PortletPreferences getPreferences() {
		return _portletPreferences;
	}

	private final PortletPreferences _portletPreferences;

}