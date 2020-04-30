/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.portletconfiguration.util;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.filter.RenderRequestWrapper;

/**
 * @author Raymond Augé
 */
public class ConfigurationRenderRequest
	extends RenderRequestWrapper implements ConfigurationPortletRequest {

	public ConfigurationRenderRequest(
		RenderRequest renderRequest, PortletPreferences portletPreferences) {

		super(renderRequest);

		_portletPreferences = portletPreferences;
	}

	@Override
	public PortletPreferences getPreferences() {
		return _portletPreferences;
	}

	private final PortletPreferences _portletPreferences;

}