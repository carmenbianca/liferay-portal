/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.display.context;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;

/**
 * @author André de Oliveira
 */
public interface PortletURLFactory {

	public PortletURL getPortletURL() throws PortletException;

}