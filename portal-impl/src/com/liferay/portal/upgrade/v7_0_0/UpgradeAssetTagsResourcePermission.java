/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;

/**
 * @author Andrew Betts
 */
public class UpgradeAssetTagsResourcePermission extends UpgradeProcess {

	@Override
	public void doUpgrade() throws Exception {
		deleteResourcePermissions();
	}

	protected void deleteResourcePermissions() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			runSQL(
				"delete from ResourcePermission where name = " +
					"'com.liferay.portlet.asset.model.AssetTag' and scope = " +
						ResourceConstants.SCOPE_INDIVIDUAL);
		}
	}

}