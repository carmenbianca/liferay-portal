/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.authentication.openid.connect.web.internal.portal.settings.configuration.admin.display;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.security.sso.openid.connect.configuration.OpenIdConnectConfiguration;
import com.liferay.portal.settings.configuration.admin.display.PortalSettingsConfigurationScreenContributor;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Samuel Trong Tran
 */
@Component(service = PortalSettingsConfigurationScreenContributor.class)
public class OpenIdConnectPortalSettingsConfigurationScreenContributor
	implements PortalSettingsConfigurationScreenContributor {

	@Override
	public String getCategoryKey() {
		return "sso";
	}

	@Override
	public String getDeleteMVCActionCommandName() {
		return "/portal_settings/openid_connect_delete";
	}

	@Override
	public String getJspPath() {
		return "/dynamic_include/com.liferay.portal.settings.web" +
			"/openid_connect.jsp";
	}

	@Override
	public String getKey() {
		return "openid-connect";
	}

	@Override
	public String getName(Locale locale) {
		return LanguageUtil.get(
			ResourceBundleUtil.getBundle(
				locale, OpenIdConnectConfiguration.class),
			"open-id-connect-configuration-name");
	}

	@Override
	public String getSaveMVCActionCommandName() {
		return "/portal_settings/openid_connect";
	}

	@Override
	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.portal.settings.authentication.openid.connect.web)",
		unbind = "-"
	)
	private ServletContext _servletContext;

}