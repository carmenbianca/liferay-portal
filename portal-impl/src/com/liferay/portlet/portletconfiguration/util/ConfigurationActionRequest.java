/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.portletconfiguration.util;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.filter.ActionRequestWrapper;

/**
 * @author Raymond Augé
 */
public class ConfigurationActionRequest
	extends ActionRequestWrapper implements ConfigurationPortletRequest {

	public ConfigurationActionRequest(
		ActionRequest actionRequest, PortletPreferences portletPreferences) {

		super(actionRequest);

		_portletPreferences = portletPreferences;
	}

	@Override
	public PortletPreferences getPreferences() {
		return _portletPreferences;
	}

	private final PortletPreferences _portletPreferences;

}