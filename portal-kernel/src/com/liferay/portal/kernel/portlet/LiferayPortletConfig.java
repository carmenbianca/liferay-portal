/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.model.Portlet;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public interface LiferayPortletConfig extends PortletConfig {

	public static final String RUNTIME_OPTION_ESCAPE_XML =
		"javax.portlet.escapeXml";

	public static final String RUNTIME_OPTION_PORTAL_CONTEXT =
		"com.liferay.portal.portalContext";

	public Portlet getPortlet();

	@Override
	public PortletContext getPortletContext();

	public String getPortletId();

	public boolean isCopyRequestParameters();

	public boolean isWARFile();

}