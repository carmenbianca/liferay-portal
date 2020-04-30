/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.internal.verify.model;

import com.liferay.mobile.device.rules.model.MDRRuleGroupInstance;
import com.liferay.mobile.device.rules.model.impl.MDRRuleGroupInstanceModelImpl;
import com.liferay.portal.kernel.verify.model.VerifiableResourcedModel;

/**
 * @author Tomas Polesovsky
 */
public class MDRRuleGroupInstanceVerifiableModel
	implements VerifiableResourcedModel {

	@Override
	public String getModelName() {
		return MDRRuleGroupInstance.class.getName();
	}

	@Override
	public String getPrimaryKeyColumnName() {
		return "ruleGroupInstanceId";
	}

	@Override
	public String getTableName() {
		return MDRRuleGroupInstanceModelImpl.TABLE_NAME;
	}

	@Override
	public String getUserIdColumnName() {
		return "userId";
	}

}