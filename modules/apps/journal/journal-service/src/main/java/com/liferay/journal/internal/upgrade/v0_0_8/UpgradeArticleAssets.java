/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.upgrade.v0_0_8;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;

/**
 * @author Preston Crary
 * @author Alberto Chaparro
 */
public class UpgradeArticleAssets extends UpgradeProcess {

	public UpgradeArticleAssets(
		AssetEntryLocalService assetEntryLocalService,
		CompanyLocalService companyLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
		_companyLocalService = companyLocalService;
	}

	@Override
	protected void doUpgrade() throws Exception {
		updateDefaultDraftArticleAssets();
	}

	protected void updateDefaultDraftArticleAssets() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			List<Company> companies = _companyLocalService.getCompanies();

			for (Company company : companies) {
				updateDefaultDraftArticleAssets(company.getCompanyId());
			}
		}
	}

	protected void updateDefaultDraftArticleAssets(long companyId)
		throws Exception {

		try (PreparedStatement ps = connection.prepareStatement(
				StringBundler.concat(
					"select resourcePrimKey, indexable from JournalArticle ",
					"where companyId = ", companyId, " and version = ",
					JournalArticleConstants.VERSION_DEFAULT, " and status = ",
					WorkflowConstants.STATUS_DRAFT));
			ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				long resourcePrimKey = rs.getLong("resourcePrimKey");

				AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(
					JournalArticle.class.getName(), resourcePrimKey);

				if (assetEntry == null) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							StringBundler.concat(
								"Journal article with resource primary key ",
								resourcePrimKey, " does not have associated ",
								"asset entry"));
					}

					continue;
				}

				boolean indexable = rs.getBoolean("indexable");

				_assetEntryLocalService.updateEntry(
					assetEntry.getClassName(), assetEntry.getClassPK(), null,
					null, indexable, assetEntry.isVisible());
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UpgradeArticleAssets.class);

	private final AssetEntryLocalService _assetEntryLocalService;
	private final CompanyLocalService _companyLocalService;

}