/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet.async;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Neil Griffin
 */
@ProviderType
public interface PortletAsyncScopeManager {

	public void activateScopeContexts();

	public void activateScopeContexts(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		PortletConfig portletConfig);

	public void deactivateScopeContexts(boolean close);

}