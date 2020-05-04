/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.layout.prototype.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradeLocalizedColumn;
import com.liferay.portal.language.LanguageResources;
import com.liferay.portal.upgrade.v7_0_5.util.LayoutPrototypeTable;
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
			LayoutPrototypeTable.class, "name", _NAME,
			"layout-prototype-blog-title", "Name", companyIds);

		upgradeLocalizedColumn(
			LanguageResources.RESOURCE_BUNDLE_LOADER,
			LayoutPrototypeTable.class, "description", _DESCRIPTION,
			"layout-prototype-blog-description", "Description", companyIds);
	}

	private static final String _DESCRIPTION =
		"Create, edit, and view blogs from this page. Explore topics using " +
			"tags, and connect with other members that blog.";

	private static final String _NAME =
		"<?xml version='1.0' encoding='UTF-8'?><root available-locales=" +
			"\"en_US\" default-locale=\"en_US\"><Name language-id=\"en_US\">" +
				"Blog</Name></root>";

}