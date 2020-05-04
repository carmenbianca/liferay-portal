/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_1_x;

import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;

/**
 * @author Eduardo Pérez
 */
public class UpgradeAssetTagsPermission extends UpgradeProcess {

	@Override
	public void doUpgrade() throws Exception {
		deleteResourcePermissions();

		renameResourceAction();
	}

	protected void deleteResourcePermissions() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			runSQL(
				"delete from ResourcePermission where name = " +
					"'com.liferay.portlet.asset.model.AssetTag' and scope = " +
						ResourceConstants.SCOPE_INDIVIDUAL);
		}
	}

	protected void renameResourceAction() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			runSQL(
				"update ResourceAction set actionId = 'MANAGE_TAG' where " +
					"actionId = 'ADD_TAG' and name = 'com.liferay.asset.tags'");
		}
	}

}