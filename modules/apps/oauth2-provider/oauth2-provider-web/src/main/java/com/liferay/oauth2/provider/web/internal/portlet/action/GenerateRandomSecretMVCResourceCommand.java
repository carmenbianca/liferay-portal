/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.web.internal.portlet.action;

import com.liferay.oauth2.provider.util.OAuth2SecureRandomGenerator;
import com.liferay.oauth2.provider.web.internal.constants.OAuth2ProviderPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tomas Polesovsky
 */
@Component(
	property = {
		"javax.portlet.name=" + OAuth2ProviderPortletKeys.OAUTH2_ADMIN,
		"mvc.command.name=/admin/generate_random_secret"
	},
	service = MVCResourceCommand.class
)
public class GenerateRandomSecretMVCResourceCommand
	implements MVCResourceCommand {

	@Override
	public boolean serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException {

		resourceResponse.setContentType("text/plain");

		try {
			PrintWriter printWriter = resourceResponse.getWriter();

			String randomSecret =
				OAuth2SecureRandomGenerator.generateClientSecret();

			printWriter.write(randomSecret);
		}
		catch (IOException ioException) {
			throw new PortletException(ioException);
		}

		return false;
	}

}