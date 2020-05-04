/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.web.internal.portal.settings.configuration.admin.display;

import com.liferay.portal.settings.configuration.admin.display.PortalSettingsConfigurationScreenContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Drew Brokke
 */
@Component(service = PortalSettingsConfigurationScreenContributor.class)
public class
	ReservedCredentialsEditCompanyPortalSettingsConfigurationScreenContributor
		extends BaseEditCompanyPortalSettingsConfigurationScreenContributor {

	@Override
	public String getCategoryKey() {
		return "user-authentication";
	}

	@Override
	public String getJspPath() {
		return "/authentication/reserved_credentials.jsp";
	}

	@Override
	public String getKey() {
		return "reserved-credentials";
	}

}