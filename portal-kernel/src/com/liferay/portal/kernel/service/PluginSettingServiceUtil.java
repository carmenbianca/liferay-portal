/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for PluginSetting. This utility wraps
 * <code>com.liferay.portal.service.impl.PluginSettingServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PluginSettingService
 * @generated
 */
public class PluginSettingServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.PluginSettingServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PluginSetting
			updatePluginSetting(
				long companyId, String pluginId, String pluginType,
				String roles, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePluginSetting(
			companyId, pluginId, pluginType, roles, active);
	}

	public static PluginSettingService getService() {
		if (_service == null) {
			_service = (PluginSettingService)PortalBeanLocatorUtil.locate(
				PluginSettingService.class.getName());
		}

		return _service;
	}

	private static PluginSettingService _service;

}