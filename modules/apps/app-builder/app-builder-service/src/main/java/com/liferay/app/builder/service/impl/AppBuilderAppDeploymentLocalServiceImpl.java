/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.service.impl;

import com.liferay.app.builder.deploy.AppDeployer;
import com.liferay.app.builder.deploy.AppDeployerTracker;
import com.liferay.app.builder.model.AppBuilderAppDeployment;
import com.liferay.app.builder.service.base.AppBuilderAppDeploymentLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.app.builder.model.AppBuilderAppDeployment",
	service = AopService.class
)
public class AppBuilderAppDeploymentLocalServiceImpl
	extends AppBuilderAppDeploymentLocalServiceBaseImpl {

	@Override
	public AppBuilderAppDeployment addAppBuilderAppDeployment(
		long appBuilderAppId, String settings, String type) {

		AppBuilderAppDeployment appBuilderAppDeployment =
			appBuilderAppDeploymentPersistence.create(
				counterLocalService.increment());

		appBuilderAppDeployment.setAppBuilderAppId(appBuilderAppId);
		appBuilderAppDeployment.setSettings(settings);
		appBuilderAppDeployment.setType(type);

		return appBuilderAppDeploymentPersistence.update(
			appBuilderAppDeployment);
	}

	@Override
	public AppBuilderAppDeployment deleteAppBuilderAppDeployment(
			long appBuilderAppDeploymentId)
		throws PortalException {

		AppBuilderAppDeployment appBuilderAppDeployment =
			getAppBuilderAppDeployment(appBuilderAppDeploymentId);

		AppDeployer appDeployer = _appDeployerTracker.getAppDeployer(
			appBuilderAppDeployment.getType());

		try {
			if (appDeployer != null) {
				appDeployer.undeploy(
					appBuilderAppDeployment.getAppBuilderAppId());
			}
		}
		catch (PortalException portalException) {
			throw portalException;
		}
		catch (Exception exception) {
			throw new PortalException(exception);
		}

		return super.deleteAppBuilderAppDeployment(appBuilderAppDeploymentId);
	}

	@Override
	public AppBuilderAppDeployment getAppBuilderAppDeployment(
			long appBuilderAppId, String type)
		throws Exception {

		return appBuilderAppDeploymentPersistence.findByA_T(
			appBuilderAppId, type);
	}

	@Override
	public List<AppBuilderAppDeployment> getAppBuilderAppDeployments(
		long appBuilderAppId) {

		return appBuilderAppDeploymentPersistence.findByAppBuilderAppId(
			appBuilderAppId);
	}

	@Reference
	private AppDeployerTracker _appDeployerTracker;

}