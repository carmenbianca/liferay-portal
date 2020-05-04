/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.util.LoggingTimer;
import com.liferay.wiki.constants.WikiPortletKeys;

/**
 * @author Levente Hudák
 */
public class UpgradeLastPublishDate
	extends com.liferay.portal.upgrade.v7_0_0.UpgradeLastPublishDate {

	protected void addLastPublishDateColumns() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			addLastPublishDateColumn("WikiNode");
			addLastPublishDateColumn("WikiPage");
		}
	}

	@Override
	protected void doUpgrade() throws Exception {
		addLastPublishDateColumns();

		updateLastPublishDates(WikiPortletKeys.WIKI, "WikiNode");
		updateLastPublishDates(WikiPortletKeys.WIKI, "WikiPage");
	}

}