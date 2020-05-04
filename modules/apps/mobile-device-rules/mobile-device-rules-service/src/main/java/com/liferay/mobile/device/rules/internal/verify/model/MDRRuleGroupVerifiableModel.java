/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.internal.verify.model;

import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.mobile.device.rules.model.impl.MDRRuleGroupModelImpl;
import com.liferay.portal.kernel.verify.model.VerifiableResourcedModel;

/**
 * @author Tomas Polesovsky
 */
public class MDRRuleGroupVerifiableModel implements VerifiableResourcedModel {

	@Override
	public String getModelName() {
		return MDRRuleGroup.class.getName();
	}

	@Override
	public String getPrimaryKeyColumnName() {
		return "ruleGroupId";
	}

	@Override
	public String getTableName() {
		return MDRRuleGroupModelImpl.TABLE_NAME;
	}

	@Override
	public String getUserIdColumnName() {
		return "userId";
	}

}