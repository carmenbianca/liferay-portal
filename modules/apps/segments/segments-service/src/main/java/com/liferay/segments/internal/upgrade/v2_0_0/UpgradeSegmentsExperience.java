/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.internal.upgrade.v2_0_0;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author David Arques
 */
public class UpgradeSegmentsExperience extends UpgradeProcess {

	public UpgradeSegmentsExperience(CounterLocalService counterLocalService) {
		_counterLocalService = counterLocalService;
	}

	@Override
	protected void doUpgrade() throws Exception {
		_updateSegmentsExperiences();
	}

	private void _updateSegmentsExperience(
		long segmentsExperienceId, String segmentsExperienceKey) {

		StringBundler sb = new StringBundler(2);

		sb.append("update SegmentsExperience set segmentsExperienceKey = ? ");
		sb.append("where segmentsExperienceId = ?");

		String sql = sb.toString();

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, segmentsExperienceKey);
			ps.setLong(2, segmentsExperienceId);

			ps.executeUpdate();
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}
	}

	private void _updateSegmentsExperiences() throws Exception {
		StringBundler sb = new StringBundler(1);

		sb.append("select segmentsExperienceId from SegmentsExperience");

		try (PreparedStatement ps = connection.prepareStatement(
				sb.toString())) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					long segmentsExperienceId = rs.getLong(
						"segmentsExperienceId");

					_updateSegmentsExperience(
						segmentsExperienceId,
						String.valueOf(_counterLocalService.increment()));
				}
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UpgradeSegmentsExperience.class);

	private final CounterLocalService _counterLocalService;

}