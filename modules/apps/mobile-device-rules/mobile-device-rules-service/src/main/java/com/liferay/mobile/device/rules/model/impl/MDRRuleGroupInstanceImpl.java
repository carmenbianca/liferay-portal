/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.model.impl;

import com.liferay.mobile.device.rules.model.MDRAction;
import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.mobile.device.rules.service.MDRActionLocalServiceUtil;
import com.liferay.mobile.device.rules.service.MDRRuleGroupLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author Edward C. Han
 */
public class MDRRuleGroupInstanceImpl extends MDRRuleGroupInstanceBaseImpl {

	@Override
	public List<MDRAction> getActions() {
		return MDRActionLocalServiceUtil.getActions(getRuleGroupInstanceId());
	}

	@Override
	public MDRRuleGroup getRuleGroup() throws PortalException {
		return MDRRuleGroupLocalServiceUtil.getRuleGroup(getRuleGroupId());
	}

}