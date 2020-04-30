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
public class WorkflowDefinitionSearchTerms
	extends WorkflowDefinitionDisplayTerms {

	public WorkflowDefinitionSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		description = DAOParamUtil.getString(portletRequest, DESCRIPTION);
		title = DAOParamUtil.getString(portletRequest, TITLE);
	}

}