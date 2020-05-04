/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.changeset.internal.upgrade;

import com.liferay.changeset.internal.upgrade.v2_0_0.util.ChangesetCollectionTable;
import com.liferay.changeset.internal.upgrade.v2_0_0.util.ChangesetEntryTable;
import com.liferay.portal.kernel.upgrade.BaseUpgradeSQLServerDatetime;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author José Ángel Jiménez
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ChangesetServiceUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"1.0.0", "2.0.0",
			new BaseUpgradeSQLServerDatetime(
				new Class<?>[] {
					ChangesetCollectionTable.class, ChangesetEntryTable.class
				}));
	}

}