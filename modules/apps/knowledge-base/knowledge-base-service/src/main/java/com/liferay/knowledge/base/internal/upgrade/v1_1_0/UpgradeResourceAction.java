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
public class UpgradeResourceAction extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (hasResourceAction("com.liferay.knowledgebase.model.Article")) {
			updateKBArticleResourceActions();
		}

		if (hasResourceAction("com.liferay.knowledgebase.model.Template")) {
			updateKBTemplateResourceActions();
		}
	}

	protected boolean hasResourceAction(String name) throws Exception {
		try (PreparedStatement ps = connection.prepareStatement(
				"select count(*) from ResourceAction where name = ?")) {

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

	protected void updateKBArticleResourceActions() throws Exception {
		runSQL(
			"delete from ResourceAction where name = " +
				"'com.liferay.knowledgebase.model.KBArticle'");

		runSQL(
			"update ResourceAction set name = " +
				"'com.liferay.knowledgebase.model.KBArticle' where name = " +
					"'com.liferay.knowledgebase.model.Article'");

		runSQL(
			"update ResourceAction set actionId = 'MOVE_KB_ARTICLE' where " +
				"name = 'com.liferay.knowledgebase.model.KBArticle' and " +
					"actionId = 'MOVE'");
	}

	protected void updateKBTemplateResourceActions() throws Exception {
		runSQL(
			"delete from ResourceAction where name = " +
				"'com.liferay.knowledgebase.model.KBTemplate'");

		runSQL(
			"update ResourceAction set name = " +
				"'com.liferay.knowledgebase.model.KBTemplate' where name = " +
					"'com.liferay.knowledgebase.model.Template'");
	}

}