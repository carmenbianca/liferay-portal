/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.upgrade.v3_2_2;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Mariano Álvaro Sáiz
 */
public class UpgradeJournalArticleLocalization extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL(
			"create unique index IX_97DC9F36 on JournalArticleLocalization " +
				"(companyId, articlePK, title[$COLUMN_LENGTH:400$], " +
					"languageId[$COLUMN_LENGTH:75$], ctCollectionId);");
	}

}