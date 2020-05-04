/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.PortletRequest;

/**
 * @author Leonardo Barros
 */
public class WorkflowDefinitionLinkSearchTerms
	extends WorkflowDefinitionLinkDisplayTerms {

	public WorkflowDefinitionLinkSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		resource = DAOParamUtil.getString(portletRequest, RESOURCE);
		workflow = DAOParamUtil.getString(portletRequest, WORKFLOW);
	}

}