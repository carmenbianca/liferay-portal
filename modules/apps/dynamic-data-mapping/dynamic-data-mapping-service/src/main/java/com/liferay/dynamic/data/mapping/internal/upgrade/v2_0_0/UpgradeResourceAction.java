/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.upgrade.v2_0_0;

import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.util.List;

/**
 * @author Leonardo Barros
 */
public class UpgradeResourceAction extends UpgradeProcess {

	public UpgradeResourceAction(
		ResourceActionLocalService resourceActionLocalService) {

		_resourceActionLocalService = resourceActionLocalService;
	}

	@Override
	protected void doUpgrade() throws Exception {
		List<ResourceAction> resourceActions =
			_resourceActionLocalService.getResourceActions(
				"com_liferay_dynamic_data_lists_form_web_portlet_" +
					"DDLFormAdminPortlet");

		for (ResourceAction resourceAction : resourceActions) {
			_resourceActionLocalService.deleteResourceAction(resourceAction);
		}
	}

	private final ResourceActionLocalService _resourceActionLocalService;

}