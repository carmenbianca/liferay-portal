/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.internal.upgrade.v1_0_0;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.wiki.model.WikiPage;

/**
 * @author Norbert Kocsis
 */
public class UpgradeWikiPage extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			long wikiPageClassNameId = PortalUtil.getClassNameId(
				WikiPage.class.getName());

			runSQL(
				StringBundler.concat(
					"update WikiPage set createDate = (select createDate from ",
					"AssetEntry where AssetEntry.classNameId = ",
					wikiPageClassNameId,
					" and AssetEntry.classPK = WikiPage.resourcePrimKey)"));
		}
	}

}