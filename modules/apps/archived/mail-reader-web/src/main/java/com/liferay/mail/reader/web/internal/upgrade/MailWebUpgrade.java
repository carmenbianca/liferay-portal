/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.web.internal.upgrade;

import com.liferay.mail.reader.web.internal.upgrade.v1_0_0.UpgradePortletId;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.kernel.upgrade.UpgradeException;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.portal.upgrade.release.BaseUpgradeWebModuleRelease;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Fellwock
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class MailWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		BaseUpgradeWebModuleRelease upgradeWebModuleRelease =
			new BaseUpgradeWebModuleRelease() {

				@Override
				protected String getBundleSymbolicName() {
					return "com.liferay.mail.reader.web";
				}

				@Override
				protected String[] getPortletIds() {
					return new String[] {"1_WAR_mailportlet"};
				}

			};

		try {
			upgradeWebModuleRelease.upgrade();
		}
		catch (UpgradeException upgradeException) {
			throw new RuntimeException(upgradeException);
		}

		registry.register("0.0.0", "1.0.0", new DummyUpgradeStep());

		registry.register("0.0.1", "1.0.0", new UpgradePortletId());
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

}