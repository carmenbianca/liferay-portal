/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.portlet;

import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.spring.mock.web.portlet.MockActionRequest;

import java.io.IOException;

import java.util.Collection;
import java.util.Map;

import javax.portlet.ActionParameters;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletResponse;
import javax.portlet.RenderParameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 * @author Alicia García
 * @author Cristina González
 */
public class MockLiferayPortletActionRequest
	extends MockActionRequest implements LiferayPortletRequest {

	@Override
	public void cleanUp() {
	}

	@Override
	public Map<String, String[]> clearRenderParameters() {
		return null;
	}

	@Override
	public void defineObjects(
		PortletConfig portletConfig, PortletResponse portletResponse) {
	}

	@Override
	public ActionParameters getActionParameters() {
		return null;
	}

	@Override
	public long getContentLengthLong() {
		return 0;
	}

	@Override
	public HttpServletRequest getHttpServletRequest() {
		return null;
	}

	@Override
	public String getLifecycle() {
		return null;
	}

	@Override
	public HttpServletRequest getOriginalHttpServletRequest() {
		return null;
	}

	@Override
	public Part getPart(String name) throws IOException, PortletException {
		return null;
	}

	@Override
	public Collection<Part> getParts() throws IOException, PortletException {
		return null;
	}

	@Override
	public long getPlid() {
		return 0;
	}

	@Override
	public Portlet getPortlet() {
		return null;
	}

	@Override
	public PortletContext getPortletContext() {
		return null;
	}

	@Override
	public String getPortletName() {
		return null;
	}

	@Override
	public HttpServletRequest getPortletRequestDispatcherRequest() {
		return null;
	}

	@Override
	public RenderParameters getRenderParameters() {
		return null;
	}

	@Override
	public String getUserAgent() {
		return null;
	}

	@Override
	public void invalidateSession() {
	}

	@Override
	public void setPortletRequestDispatcherRequest(
		HttpServletRequest httpServletRequest) {
	}

}