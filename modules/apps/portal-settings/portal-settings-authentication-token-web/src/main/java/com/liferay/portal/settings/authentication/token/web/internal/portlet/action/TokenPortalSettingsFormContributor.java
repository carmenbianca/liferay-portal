/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.authentication.token.web.internal.portlet.action;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.token.constants.TokenConstants;
import com.liferay.portal.settings.authentication.token.web.internal.constants.PortalSettingsTokenConstants;
import com.liferay.portal.settings.portlet.action.PortalSettingsFormContributor;
import com.liferay.portal.settings.portlet.action.PortalSettingsParameterUtil;

import java.util.Optional;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Stian Sigvartsen
 */
@Component(service = PortalSettingsFormContributor.class)
public class TokenPortalSettingsFormContributor
	implements PortalSettingsFormContributor {

	@Override
	public Optional<String> getDeleteMVCActionCommandNameOptional() {
		return Optional.of("/portal_settings/token_delete");
	}

	@Override
	public String getParameterNamespace() {
		return PortalSettingsTokenConstants.FORM_PARAMETER_NAMESPACE;
	}

	@Override
	public Optional<String> getSaveMVCActionCommandNameOptional() {
		return Optional.of("/portal_settings/token");
	}

	@Override
	public String getSettingsId() {
		return TokenConstants.SERVICE_NAME;
	}

	@Override
	public void validateForm(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		boolean tokenEnabled = PortalSettingsParameterUtil.getBoolean(
			actionRequest, this, "enabled");

		if (!tokenEnabled) {
			return;
		}

		String logoutRedirectURL = PortalSettingsParameterUtil.getString(
			actionRequest, this, "logoutRedirectURL");

		if (Validator.isNotNull(logoutRedirectURL) &&
			!Validator.isUrl(logoutRedirectURL)) {

			SessionErrors.add(actionRequest, "logoutRedirectURLInvalid");
		}
	}

}