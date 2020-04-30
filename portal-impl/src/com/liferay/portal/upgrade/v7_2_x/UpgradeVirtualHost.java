/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_2_x;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Raymond Augé
 */
public class UpgradeVirtualHost extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL("alter table VirtualHost add defaultVirtualHost BOOLEAN;");

		runSQL("alter table VirtualHost add languageId VARCHAR(75) null;");

		runSQL("update VirtualHost set defaultVirtualHost = TRUE;");
	}

}