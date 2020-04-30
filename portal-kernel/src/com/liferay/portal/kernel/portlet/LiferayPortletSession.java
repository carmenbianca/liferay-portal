/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import javax.portlet.PortletSession;

import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 */
public interface LiferayPortletSession extends PortletSession {

	public static final String LAYOUT_SEPARATOR = "_LAYOUT_";

	public static final String PORTLET_SCOPE_NAMESPACE = "javax.portlet.p.";

	public void setHttpSession(HttpSession session);

}