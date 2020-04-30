/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.internal.upgrade.v1_2_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Michael C. Han
 */
public class UpgradeKaleoNotificationRecipient extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		try (PreparedStatement ps = connection.prepareStatement(
				"update KaleoNotificationRecipient set recipientClassName = " +
					"'ADDRESS' where recipientClassName is null or " +
						"recipientClassName = ''")) {

			ps.executeUpdate();
		}
		catch (SQLException sqlException) {
		}
	}

}