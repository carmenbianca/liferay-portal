/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.display;

import com.liferay.configuration.admin.display.ConfigurationScreen;
import com.liferay.petra.lang.HashUtil;

import java.util.Locale;
import java.util.Objects;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Jorge Ferrer
 */
public class ConfigurationScreenConfigurationEntry
	implements ConfigurationEntry {

	public ConfigurationScreenConfigurationEntry(
		ConfigurationScreen configurationScreen, Locale locale) {

		_configurationScreen = configurationScreen;
		_locale = locale;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConfigurationEntry)) {
			return false;
		}

		ConfigurationEntry configurationEntry = (ConfigurationEntry)obj;

		if (Objects.equals(getCategory(), configurationEntry.getCategory()) &&
			Objects.equals(getKey(), configurationEntry.getKey()) &&
			Objects.equals(getScope(), configurationEntry.getScope())) {

			return true;
		}

		return false;
	}

	@Override
	public String getCategory() {
		return _configurationScreen.getCategoryKey();
	}

	@Override
	public String getEditURL(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter(
			"mvcRenderCommandName", "/view_configuration_screen");
		portletURL.setParameter(
			"configurationScreenKey", _configurationScreen.getKey());

		return portletURL.toString();
	}

	@Override
	public String getKey() {
		return _configurationScreen.getKey();
	}

	@Override
	public String getName() {
		return _configurationScreen.getName(_locale);
	}

	@Override
	public String getScope() {
		return _configurationScreen.getScope();
	}

	@Override
	public int hashCode() {
		int hash = HashUtil.hash(0, getCategory());

		hash = HashUtil.hash(hash, getKey());
		hash = HashUtil.hash(hash, getScope());

		return hash;
	}

	private final ConfigurationScreen _configurationScreen;
	private final Locale _locale;

}