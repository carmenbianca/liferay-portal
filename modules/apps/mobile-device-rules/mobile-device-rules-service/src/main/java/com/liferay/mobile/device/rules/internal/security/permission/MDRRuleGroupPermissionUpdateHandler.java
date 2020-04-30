/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.internal.security.permission;

import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.mobile.device.rules.service.MDRRuleGroupLocalService;
import com.liferay.portal.kernel.security.permission.PermissionUpdateHandler;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gergely Mathe
 */
@Component(
	property = "model.class.name=com.liferay.mobile.device.rules.model.MDRRuleGroup",
	service = PermissionUpdateHandler.class
)
public class MDRRuleGroupPermissionUpdateHandler
	implements PermissionUpdateHandler {

	@Override
	public void updatedPermission(String primKey) {
		MDRRuleGroup mdrRuleGroup = _mdrRuleGroupLocalService.fetchMDRRuleGroup(
			GetterUtil.getLong(primKey));

		if (mdrRuleGroup == null) {
			return;
		}

		mdrRuleGroup.setModifiedDate(new Date());

		_mdrRuleGroupLocalService.updateMDRRuleGroup(mdrRuleGroup);
	}

	@Reference(unbind = "-")
	protected void setMDRRuleGroupLocalService(
		MDRRuleGroupLocalService mdrRuleGroupLocalService) {

		_mdrRuleGroupLocalService = mdrRuleGroupLocalService;
	}

	private MDRRuleGroupLocalService _mdrRuleGroupLocalService;

}