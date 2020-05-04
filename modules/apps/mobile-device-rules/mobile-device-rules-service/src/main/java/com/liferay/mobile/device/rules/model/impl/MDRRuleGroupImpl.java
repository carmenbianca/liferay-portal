/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.model.impl;

import com.liferay.mobile.device.rules.model.MDRRule;
import com.liferay.mobile.device.rules.service.MDRRuleLocalServiceUtil;

import java.util.Collections;
import java.util.List;

/**
 * @author Edward C. Han
 */
public class MDRRuleGroupImpl extends MDRRuleGroupBaseImpl {

	@Override
	public List<MDRRule> getRules() {
		if (getRuleGroupId() > 0) {
			return MDRRuleLocalServiceUtil.getRules(getRuleGroupId());
		}

		return Collections.emptyList();
	}

}