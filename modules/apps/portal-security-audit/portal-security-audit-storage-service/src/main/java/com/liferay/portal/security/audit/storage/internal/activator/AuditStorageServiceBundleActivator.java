/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.audit.storage.internal.activator;

import com.liferay.portal.upgrade.release.BaseUpgradeServiceModuleRelease;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Alan Huang
 */
public class AuditStorageServiceBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		BaseUpgradeServiceModuleRelease upgradeServiceModuleRelease =
			new BaseUpgradeServiceModuleRelease() {

				@Override
				protected String getNamespace() {
					return "Audit";
				}

				@Override
				protected String getNewBundleSymbolicName() {
					return "com.liferay.portal.security.audit.storage.service";
				}

				@Override
				protected String getOldBundleSymbolicName() {
					return "audit-portlet";
				}

			};

		upgradeServiceModuleRelease.upgrade();
	}

	@Override
	public void stop(BundleContext context) {
	}

}