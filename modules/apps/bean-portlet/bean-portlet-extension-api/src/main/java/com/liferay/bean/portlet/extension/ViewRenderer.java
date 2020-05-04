/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.extension;

import javax.portlet.MimeResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Neil Griffin
 */
@ProviderType
public interface ViewRenderer {

	public static final String REDIRECT_PREFIX = "redirect:";

	public static final String REDIRECTED_VIEW = "redirectedView";

	public static final String VIEW_NAME = "viewName";

	public void render(
			MimeResponse mimeResponse, PortletConfig portletConfig,
			PortletRequest portletRequest)
		throws PortletException;

}