/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.upgrade.v1_0_0;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Peter Shin
 */
public class UpgradeRatingsEntry extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		updateRatingsEntries();
	}

	protected long getClassNameId(String className) throws Exception {
		try (PreparedStatement ps = connection.prepareStatement(
				"select classNameId from ClassName_ where value = ?")) {

			ps.setString(1, className);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getLong("classNameId");
				}

				return 0;
			}
		}
	}

	protected void updateRatingsEntries() throws Exception {
		try (PreparedStatement ps = connection.prepareStatement(
				"select entryId, score from RatingsEntry where classNameId = " +
					getClassNameId(_ARTICLE_CLASS_NAME));
			ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				long entryId = rs.getLong("entryId");
				double score = rs.getDouble("score");

				StringBundler sb = new StringBundler(4);

				sb.append("update RatingsEntry set score = ");
				sb.append(score * 2);
				sb.append(" where entryId = ");
				sb.append(entryId);

				runSQL(sb.toString());
			}
		}
	}

	private static final String _ARTICLE_CLASS_NAME =
		"com.liferay.knowledgebase.model.Article";

}