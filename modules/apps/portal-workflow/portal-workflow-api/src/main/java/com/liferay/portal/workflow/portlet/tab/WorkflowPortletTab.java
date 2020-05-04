/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.portlet.tab;

import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.ServletContext;

/**
 * @author Adam Brandizzi
 */
public interface WorkflowPortletTab extends DynamicInclude {

	public String getName();

	public String getSearchJspPath();

	public PortletURL getSearchURL(
		RenderRequest renderRequest, RenderResponse renderResponse);

	public ServletContext getServletContext();

	public void prepareDispatch(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException;

	public void prepareProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException;

	public void prepareRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException;

}