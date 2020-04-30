/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.license.deployer.internal;

import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.license.deployer.internal.installer.LicenseInstaller;

import org.apache.felix.fileinstall.ArtifactInstaller;
import org.apache.felix.fileinstall.ArtifactListener;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.tracker.BundleTracker;

/**
 * @author Miguel Pastor
 */
@Component(immediate = true, service = {})
public class LicenseDeployerActivator {

	@Activate
	protected void activate(BundleContext bundleContext) {
		ArtifactInstaller artifactInstaller = new LicenseInstaller();

		_artifactListenerServiceRegistration = registerArtifactListener(
			bundleContext, artifactInstaller);

		_lpkgLicensedBundleTracker = new BundleTracker<>(
			bundleContext, ~Bundle.UNINSTALLED,
			new LPKGLicensedBundleTrackerCustomizer(artifactInstaller));

		_lpkgLicensedBundleTracker.open();
	}

	@Deactivate
	protected void deactivate() {
		_artifactListenerServiceRegistration.unregister();
	}

	protected ServiceRegistration<?> registerArtifactListener(
		BundleContext bundleContext, ArtifactInstaller artifactInstaller) {

		return bundleContext.registerService(
			new String[] {
				ArtifactInstaller.class.getName(),
				ArtifactListener.class.getName()
			},
			artifactInstaller, null);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	private ServiceRegistration<?> _artifactListenerServiceRegistration;
	private BundleTracker<Bundle> _lpkgLicensedBundleTracker;

}