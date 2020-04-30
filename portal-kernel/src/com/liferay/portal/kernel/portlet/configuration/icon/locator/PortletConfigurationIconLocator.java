/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet.configuration.icon.locator;

import java.util.List;

import javax.portlet.PortletRequest;

/**
 * @author Eudaldo Alonso
 */
public interface PortletConfigurationIconLocator {

	public List<String> getDefaultViews(String portletId);

	public String getPath(PortletRequest portletRequest);

}