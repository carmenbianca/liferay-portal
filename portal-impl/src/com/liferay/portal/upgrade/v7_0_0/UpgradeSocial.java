/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.counter.kernel.model.Counter;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Adolfo Pérez
 */
public class UpgradeSocial extends UpgradeProcess {

	protected void addSocialActivitySets(long delta) throws Exception {
		try (Statement s = connection.createStatement()) {
			StringBundler sb = new StringBundler(6);

			sb.append("insert into SocialActivitySet select (activityId + ");
			sb.append(delta);
			sb.append(") as activitySetId, groupId, companyId, userId, ");
			sb.append("createDate, createDate AS modifiedDate, classNameId, ");
			sb.append("classPK, type_, extraData, 1 as activityCount from ");
			sb.append("SocialActivity where mirrorActivityId = 0");

			s.execute(sb.toString());
		}
	}

	protected void deleteOrphanedSocialRequests() throws Exception {
		try (PreparedStatement ps = connection.prepareStatement(
				"delete from SocialRequest where classNameId = ? and classPK " +
					"not in (select groupId from Group_)")) {

			ps.setLong(
				1,
				PortalUtil.getClassNameId(
					"com.liferay.portal.kernel.model.Group"));

			ps.execute();
		}
	}

	@Override
	protected void doUpgrade() throws Exception {
		if (getSocialActivitySetsCount() > 0) {
			return;
		}

		long increment = increment();

		long delta = getDelta(increment);

		addSocialActivitySets(delta);

		deleteOrphanedSocialRequests();

		updateSocialActivities(delta);

		long counterIncrement = _getCounterIncrement();

		while (counterIncrement > Integer.MAX_VALUE) {
			increment(Counter.class.getName(), Integer.MAX_VALUE);

			counterIncrement -= Integer.MAX_VALUE;
		}

		if (counterIncrement > 0) {
			increment(Counter.class.getName(), (int)counterIncrement);
		}
	}

	protected long getDelta(long increment) throws Exception {
		try (Statement s = connection.createStatement()) {
			try (ResultSet rs = s.executeQuery(
					"select min(activityId) from SocialActivity")) {

				if (rs.next()) {
					long minActivityId = rs.getLong(1);

					return increment - minActivityId;
				}

				return 0;
			}
		}
	}

	protected int getSocialActivitySetsCount() throws Exception {
		try (Statement s = connection.createStatement()) {
			String query = "select count(activitySetId) from SocialActivitySet";

			try (ResultSet rs = s.executeQuery(query)) {
				if (rs.next()) {
					return rs.getInt(1);
				}

				return 0;
			}
		}
	}

	protected void updateSocialActivities(long delta) throws Exception {
		try (PreparedStatement ps = connection.prepareStatement(
				"update SocialActivity set activitySetId = (activityId + ?) " +
					"where mirrorActivityId = 0")) {

			ps.setLong(1, delta);

			ps.execute();
		}
	}

	private long _getCounterIncrement() throws Exception {
		try (PreparedStatement ps1 = connection.prepareStatement(
				"select currentId from Counter where name = ?")) {

			ps1.setString(1, Counter.class.getName());

			long counter = 0;

			try (ResultSet rs = ps1.executeQuery()) {
				if (rs.next()) {
					counter = rs.getLong("currentId");
				}
			}

			PreparedStatement ps2 = connection.prepareStatement(
				"select max(activitySetId) from SocialActivitySet");

			try (ResultSet rs = ps2.executeQuery()) {
				if (rs.next()) {
					return Math.max(0, rs.getLong(1) - counter);
				}

				return 0;
			}
		}
	}

}