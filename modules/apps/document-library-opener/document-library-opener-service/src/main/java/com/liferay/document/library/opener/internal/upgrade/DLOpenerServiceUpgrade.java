/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.opener.internal.upgrade;

import com.liferay.document.library.opener.internal.upgrade.v1_1_0.UpgradeDLOpenerFileEntryReference;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Cristina González
 */
@Component(service = UpgradeStepRegistrator.class)
public class DLOpenerServiceUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"1.0.0", "1.1.0", new UpgradeDLOpenerFileEntryReference());
	}

}