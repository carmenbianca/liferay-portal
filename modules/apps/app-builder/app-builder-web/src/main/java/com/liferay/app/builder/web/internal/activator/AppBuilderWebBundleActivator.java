/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.web.internal.activator;

import com.liferay.app.builder.constants.AppBuilderAppConstants;
import com.liferay.app.builder.deploy.AppDeployer;
import com.liferay.app.builder.service.AppBuilderAppLocalServiceUtil;
import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * @author Jeyvison Nascimento
 */
public class AppBuilderWebBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		_serviceTracker = ServiceTrackerFactory.open(
			bundleContext, AppDeployer.class,
			new AppDeployerServiceTrackerCustomizer(bundleContext));
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		_serviceTracker.close();
	}

	private ServiceTracker<AppDeployer, AppDeployer> _serviceTracker;

	private class AppDeployerServiceTrackerCustomizer
		implements ServiceTrackerCustomizer<AppDeployer, AppDeployer> {

		@Override
		public AppDeployer addingService(
			ServiceReference<AppDeployer> serviceReference) {

			List<Long> appBuilderAppIds =
				AppBuilderAppLocalServiceUtil.getAppBuilderAppIds(
					AppBuilderAppConstants.STATUS_DEPLOYED,
					(String)serviceReference.getProperty(
						"app.builder.deploy.type"));

			AppDeployer appDeployer = _bundleContext.getService(
				serviceReference);

			for (Long appBuilderAppId : appBuilderAppIds) {
				try {
					appDeployer.deploy(appBuilderAppId);
				}
				catch (Exception exception) {
					_log.error(
						"Unable to deploy app " + appBuilderAppId, exception);
				}
			}

			return appDeployer;
		}

		@Override
		public void modifiedService(
			ServiceReference<AppDeployer> serviceReference,
			AppDeployer appDeployer) {
		}

		@Override
		public void removedService(
			ServiceReference<AppDeployer> serviceReference,
			AppDeployer appDeployer) {
		}

		private AppDeployerServiceTrackerCustomizer(
			BundleContext bundleContext) {

			_bundleContext = bundleContext;
		}

		private final BundleContext _bundleContext;
		private final Log _log = LogFactoryUtil.getLog(
			AppDeployerServiceTrackerCustomizer.class.getName());

	}

}