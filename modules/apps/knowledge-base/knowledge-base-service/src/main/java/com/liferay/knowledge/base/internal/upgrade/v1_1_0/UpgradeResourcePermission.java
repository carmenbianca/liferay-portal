/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.upgrade.v1_1_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Peter Shin
 */
public class UpgradeResourcePermission extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (hasResourcePermission("com.liferay.knowledgebase.model.Article")) {
			updateKBArticleResourcePermissions();
		}

		if (hasResourcePermission("com.liferay.knowledgebase.model.Template")) {
			updateKBTemplateResourcePermissions();
		}
	}

	protected boolean hasResourcePermission(String name) throws Exception {
		try (PreparedStatement ps = connection.prepareStatement(
				"select count(*) from ResourcePermission where name = ?")) {

			ps.setString(1, name);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int count = rs.getInt(1);

					if (count > 0) {
						return true;
					}
				}

				return false;
			}
		}
	}

	protected void updateKBArticleResourcePermissions() throws Exception {
		runSQL(
			"update ResourcePermission set name = " +
				"'com.liferay.knowledgebase.model.KBArticle' where name = " +
					"'com.liferay.knowledgebase.model.Article'");
	}

	protected void updateKBTemplateResourcePermissions() throws Exception {
		runSQL(
			"update ResourcePermission set name = " +
				"'com.liferay.knowledgebase.model.KBTemplate' where name = " +
					"'com.liferay.knowledgebase.model.Template'");
	}

}