/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.portlet.container.embedded.test;

import com.liferay.portal.osgi.web.portlet.container.test.TestPortlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Manuel de la Peña
 */
public class TestRuntimePortlet extends TestPortlet {

	public boolean isCalledRuntime() {
		return _calledRuntime;
	}

	/**
	 * @throws IOException
	 */
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		_calledRuntime = true;

		super.render(renderRequest, renderResponse);
	}

	private boolean _calledRuntime;

}