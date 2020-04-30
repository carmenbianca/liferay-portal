/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.internal.upgrade.v1_1_0;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Adolfo Pérez
 */
public class UpgradeFriendlyURL extends UpgradeProcess {

	public UpgradeFriendlyURL(
		FriendlyURLEntryLocalService friendlyURLEntryLocalService) {

		_friendlyURLEntryLocalService = friendlyURLEntryLocalService;
	}

	@Override
	protected void doUpgrade() throws Exception {
		try (PreparedStatement ps1 = connection.prepareStatement(
				"select groupId, entryId, urlTitle from BlogsEntry")) {

			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				long groupId = rs.getLong(1);
				long classPK = rs.getLong(2);
				String urlTitle = rs.getString(3);

				_friendlyURLEntryLocalService.addFriendlyURLEntry(
					groupId, BlogsEntry.class, classPK, urlTitle,
					new ServiceContext());
			}
		}
	}

	private final FriendlyURLEntryLocalService _friendlyURLEntryLocalService;

}