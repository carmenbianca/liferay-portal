/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.web.internal.portal.settings.configuration.admin.display;

import com.liferay.portal.settings.configuration.admin.display.PortalSettingsConfigurationScreenContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Drew Brokke
 */
@Component(service = PortalSettingsConfigurationScreenContributor.class)
public class FieldsEditCompanyPortalSettingsConfigurationScreenContributor
	extends BaseEditCompanyPortalSettingsConfigurationScreenContributor {

	@Override
	public String getCategoryKey() {
		return "users";
	}

	@Override
	public String getJspPath() {
		return "/users/fields.jsp";
	}

	@Override
	public String getKey() {
		return "user-fields";
	}

	@Override
	public String getName(Locale locale) {
		return "fields";
	}

}