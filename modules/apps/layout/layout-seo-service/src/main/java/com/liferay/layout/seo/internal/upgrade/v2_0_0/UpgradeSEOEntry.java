/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.internal.upgrade.v2_0_0;

import com.liferay.layout.seo.internal.upgrade.v2_0_0.util.LayoutSEOEntryTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Cristina González
 */
public class UpgradeSEOEntry extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			LayoutSEOEntryTable.class,
			new AlterColumnName("enabled", "canonicalURLEnabled BOOLEAN"),
			new AlterTableAddColumn("openGraphTitleEnabled", "BOOLEAN"),
			new AlterTableAddColumn("openGraphTitle", "STRING null"),
			new AlterTableAddColumn("openGraphDescriptionEnabled", "BOOLEAN"),
			new AlterTableAddColumn("openGraphDescription", "STRING null"),
			new AlterTableAddColumn("openGraphImageFileEntryId", "LONG"));
	}

}