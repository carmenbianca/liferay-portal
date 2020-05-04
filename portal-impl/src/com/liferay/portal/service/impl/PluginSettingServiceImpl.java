/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PluginSetting;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.service.base.PluginSettingServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class PluginSettingServiceImpl extends PluginSettingServiceBaseImpl {

	@Override
	public PluginSetting updatePluginSetting(
			long companyId, String pluginId, String pluginType, String roles,
			boolean active)
		throws PortalException {

		if (!roleLocalService.hasUserRole(
				getUserId(), companyId, RoleConstants.ADMINISTRATOR, true)) {

			throw new PrincipalException();
		}

		return pluginSettingLocalService.updatePluginSetting(
			companyId, pluginId, pluginType, roles, active);
	}

}