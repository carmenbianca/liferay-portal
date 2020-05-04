/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.bridges.wai;

import com.liferay.portal.kernel.portlet.LiferayPortlet;

import java.io.IOException;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Jorge Ferrer
 * @author Connor McKay
 */
public class WAIPortlet extends LiferayPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletContext portletContext = getPortletContext();

		PortletRequestDispatcher portletRequestDispatcher =
			portletContext.getRequestDispatcher(_JSP_IFRAME);

		portletRequestDispatcher.include(renderRequest, renderResponse);
	}

	private static final String _JSP_DIR = "/WEB-INF/jsp/liferay/wai";

	private static final String _JSP_IFRAME = _JSP_DIR + "/iframe.jsp";

}