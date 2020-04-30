/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.activator;

import com.liferay.portal.upgrade.release.BaseUpgradeServiceModuleRelease;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Adolfo Pérez
 */
public class KnowledgeBaseServiceBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		BaseUpgradeServiceModuleRelease upgradeServiceModuleRelease =
			new BaseUpgradeServiceModuleRelease() {

				@Override
				protected String getNamespace() {
					return "KB";
				}

				@Override
				protected String getNewBundleSymbolicName() {
					return "com.liferay.knowledge.base.service";
				}

				@Override
				protected String getOldBundleSymbolicName() {
					return "knowledge-base-portlet";
				}

			};

		upgradeServiceModuleRelease.upgrade();
	}

	@Override
	public void stop(BundleContext bundleContext) {
	}

}