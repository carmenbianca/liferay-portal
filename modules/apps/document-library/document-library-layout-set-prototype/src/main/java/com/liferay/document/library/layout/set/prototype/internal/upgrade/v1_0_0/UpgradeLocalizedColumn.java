/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.layout.set.prototype.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradeLocalizedColumn;
import com.liferay.portal.language.LanguageResources;
import com.liferay.portal.upgrade.v7_1_x.util.LayoutSetPrototypeTable;
import com.liferay.portal.util.PortalInstances;

/**
 * @author Leon Chi
 */
public class UpgradeLocalizedColumn extends BaseUpgradeLocalizedColumn {

	@Override
	protected void doUpgrade() throws Exception {
		long[] companyIds = PortalInstances.getCompanyIdsBySQL();

		upgradeLocalizedColumn(
			LanguageResources.RESOURCE_BUNDLE_LOADER,
			LayoutSetPrototypeTable.class, "name", _NAME,
			"layout-set-prototype-intranet-site-title", "Name", companyIds);

		upgradeLocalizedColumn(
			LanguageResources.RESOURCE_BUNDLE_LOADER,
			LayoutSetPrototypeTable.class, "description", _DESCRIPTION,
			"layout-set-prototype-intranet-site-description", "Description",
			companyIds);
	}

	private static final String _DESCRIPTION = "Site with Documents and News";

	private static final String _NAME =
		"<?xml version='1.0' encoding='UTF-8'?><root available-locales=" +
			"\"en_US\" default-locale=\"en_US\"><Name language-id=\"en_US\">" +
				"Intranet Site</Name></root>";

}