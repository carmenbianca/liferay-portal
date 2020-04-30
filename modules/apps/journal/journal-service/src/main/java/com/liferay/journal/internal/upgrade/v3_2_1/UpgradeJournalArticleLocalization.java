/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.upgrade.v3_2_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Mariano Álvaro Sáiz
 */
public class UpgradeJournalArticleLocalization extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL(
			"create unique index IX_9B44D13C on JournalArticleLocalization " +
				"(companyId, articlePK, languageId[$COLUMN_LENGTH:75$], " +
					"ctCollectionId)");
	}

}