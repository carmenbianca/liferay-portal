/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.LoggingTimer;
import com.liferay.portal.language.LanguageResources;
import com.liferay.portal.upgrade.v7_0_0.util.GroupTable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Eudaldo Alonso
 */
public class UpgradeGroup extends UpgradeProcess {

	protected void createIndex() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			runSQL("create index IX_8257E37B on Group_ (classNameId, classPK)");
		}
	}

	@Override
	protected void doUpgrade() throws Exception {
		alter(GroupTable.class, new AlterColumnType("name", "STRING null"));

		createIndex();

		updateGlobalGroupName();
	}

	protected void updateGlobalGroupName() throws Exception {
		List<Long> companyIds = new ArrayList<>();

		try (PreparedStatement ps = connection.prepareStatement(
				"select companyId from Company")) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					long companyId = rs.getLong("companyId");

					companyIds.add(companyId);
				}
			}
		}

		for (Long companyId : companyIds) {
			LocalizedValuesMap localizedValuesMap = new LocalizedValuesMap();

			for (Locale locale :
					LanguageUtil.getCompanyAvailableLocales(companyId)) {

				localizedValuesMap.put(
					locale,
					LanguageUtil.get(
						LanguageResources.getResourceBundle(locale), "global"));
			}

			String nameXML = LocalizationUtil.getXml(
				localizedValuesMap, "global");

			try (PreparedStatement ps = connection.prepareStatement(
					"update Group_ set name = ? where companyId = ? and " +
						"friendlyURL = '/global'")) {

				ps.setString(1, nameXML);
				ps.setLong(2, companyId);

				ps.executeUpdate();
			}
		}
	}

}