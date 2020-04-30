/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.web.internal.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.PortletRequest;

/**
 * @author Edward Han
 */
public class RuleGroupSearchTerms extends RuleGroupDisplayTerms {

	public RuleGroupSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		setGroupId(DAOParamUtil.getLong(portletRequest, GROUP_ID));
		setName(DAOParamUtil.getString(portletRequest, NAME));
	}

}