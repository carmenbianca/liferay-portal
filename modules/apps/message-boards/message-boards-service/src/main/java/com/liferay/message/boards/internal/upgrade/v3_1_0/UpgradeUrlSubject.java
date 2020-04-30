/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.upgrade.v3_1_0;

import com.liferay.message.boards.internal.upgrade.v3_1_0.util.MBMessageTable;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.jdbc.AutoBatchPreparedStatementUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Javier Gamarra
 */
public class UpgradeUrlSubject extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("MBMessage", "urlSubject")) {
			alter(
				MBMessageTable.class,
				new AlterTableAddColumn("urlSubject", "VARCHAR(255) null"));
		}

		_populateUrlSubject();
	}

	private String _findUniqueUrlSubject(Connection con, String urlSubject)
		throws SQLException {

		try (PreparedStatement ps = con.prepareStatement(
				"select count(*) from MBMessage where urlSubject like ?")) {

			ps.setString(1, urlSubject + "%");

			try (ResultSet rs = ps.executeQuery()) {
				if (!rs.next()) {
					return urlSubject;
				}

				int mbMessageCount = rs.getInt(1);

				if (mbMessageCount == 0) {
					return urlSubject;
				}

				return urlSubject + StringPool.DASH + mbMessageCount;
			}
		}
	}

	private String _getUrlSubject(long id, String subject) {
		if (subject == null) {
			return String.valueOf(id);
		}

		subject = StringUtil.toLowerCase(subject.trim());

		if (Validator.isNull(subject) || Validator.isNumber(subject) ||
			subject.equals("rss")) {

			subject = String.valueOf(id);
		}
		else {
			subject = FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
				subject);
		}

		return subject.substring(0, Math.min(subject.length(), 254));
	}

	private void _populateUrlSubject() throws SQLException {
		try (PreparedStatement ps1 = connection.prepareStatement(
				"select messageId, subject from MBMessage where (urlSubject " +
					"is null) or (urlSubject = '')");
			ResultSet rs = ps1.executeQuery();
			PreparedStatement ps2 = AutoBatchPreparedStatementUtil.autoBatch(
				connection.prepareStatement(
					"update MBMessage set urlSubject = ? where messageId = " +
						"?"))) {

			while (rs.next()) {
				long messageId = rs.getLong(1);
				String subject = rs.getString(2);

				String urlSubject = _getUrlSubject(messageId, subject);

				String uniqueUrlSubject = _findUniqueUrlSubject(
					connection, urlSubject);

				ps2.setString(1, uniqueUrlSubject);

				ps2.setLong(2, messageId);

				ps2.addBatch();
			}

			ps2.executeBatch();
		}
	}

}