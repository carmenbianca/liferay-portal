/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.portlet.action;

import java.util.Optional;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface PortalSettingsFormContributor {

	public Optional<String> getDeleteMVCActionCommandNameOptional();

	public String getParameterNamespace();

	public Optional<String> getSaveMVCActionCommandNameOptional();

	public String getSettingsId();

	public void validateForm(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException;

}