/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.deploy;

import com.liferay.app.builder.constants.AppBuilderAppConstants;
import com.liferay.app.builder.model.AppBuilderApp;
import com.liferay.app.builder.service.AppBuilderAppLocalService;

import java.util.concurrent.ConcurrentHashMap;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.ServiceRegistration;

/**
 * @author Jeyvison Nascimento
 */
@ProviderType
public interface AppDeployer {

	public void deploy(long appId) throws Exception;

	public default boolean undeploy(
			AppBuilderAppLocalService appBuilderAppLocalService, long appId,
			ConcurrentHashMap<Long, ServiceRegistration<?>[]>
				serviceRegistrationsMap)
		throws Exception {

		ServiceRegistration<?>[] serviceRegistrations =
			serviceRegistrationsMap.remove(appId);

		if (serviceRegistrations == null) {
			return false;
		}

		for (ServiceRegistration serviceRegistration : serviceRegistrations) {
			serviceRegistration.unregister();
		}

		AppBuilderApp appBuilderApp =
			appBuilderAppLocalService.getAppBuilderApp(appId);

		appBuilderApp.setStatus(
			AppBuilderAppConstants.Status.UNDEPLOYED.getValue());

		appBuilderAppLocalService.updateAppBuilderApp(appBuilderApp);

		return true;
	}

	public void undeploy(long appId) throws Exception;

}