/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.internal.upgrade.v1_1_1;

import com.liferay.layout.page.template.constants.LayoutPageTemplateEntryTypeConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.dao.orm.common.SQLTransformer;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Jonathan McCann
 */
public class UpgradeLayoutPageTemplateEntry extends UpgradeProcess {

	public UpgradeLayoutPageTemplateEntry(
		CompanyLocalService companyLocalService) {

		_companyLocalService = companyLocalService;
	}

	@Override
	protected void doUpgrade() throws Exception {
		StringBundler sb = new StringBundler(6);

		sb.append("select layoutPageTemplateEntryId, companyId, name, ");
		sb.append("layoutPrototypeId from LayoutPageTemplateEntry where ");
		sb.append("type_ = ");
		sb.append(LayoutPageTemplateEntryTypeConstants.TYPE_WIDGET_PAGE);
		sb.append(" and groupId in (select groupId from Group_ where site = ");
		sb.append("[$FALSE$])");

		try (PreparedStatement ps = connection.prepareStatement(
				SQLTransformer.transform(sb.toString()));
			ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				long layoutPageTemplateEntryId = rs.getLong(
					"layoutPageTemplateEntryId");
				long companyId = rs.getLong("companyId");
				String name = rs.getString("name");
				long layoutPrototypeId = rs.getLong("layoutPrototypeId");

				_updateLayoutPageTemplateEntry(
					layoutPageTemplateEntryId, companyId, name,
					layoutPrototypeId);
			}
		}
	}

	private void _updateLayoutPageTemplateEntry(
			long layoutPageTemplateEntryId, long companyId, String name,
			long layoutPrototypeId)
		throws Exception {

		Company company = _companyLocalService.getCompany(companyId);

		String newName = name;

		for (int i = 1;; i++) {
			StringBundler sb = new StringBundler(6);

			sb.append("select count(*) from LayoutPageTemplateEntry where ");
			sb.append("groupId = ");
			sb.append(company.getGroupId());
			sb.append(" and name = '");
			sb.append(newName);
			sb.append("'");

			try (PreparedStatement ps = connection.prepareStatement(
					sb.toString());
				ResultSet rs = ps.executeQuery()) {

				if (rs.next() && (rs.getInt(1) > 0)) {
					newName = name + i;
				}
				else {
					break;
				}
			}
		}

		StringBundler sb = new StringBundler(6);

		sb.append("update LayoutPageTemplateEntry set groupId = ");
		sb.append(company.getGroupId());
		sb.append(", layoutPageTemplateCollectionId = 0, name = '");
		sb.append(newName);
		sb.append("' where layoutPageTemplateEntryId = ");
		sb.append(layoutPageTemplateEntryId);

		runSQL(sb.toString());

		sb = new StringBundler(6);

		sb.append("delete from LayoutPageTemplateEntry where groupId <> ");
		sb.append(company.getGroupId());
		sb.append(" and layoutPageTemplateCollectionId <> 0 and type_ = ");
		sb.append(LayoutPageTemplateEntryTypeConstants.TYPE_WIDGET_PAGE);
		sb.append(" and layoutPrototypeId = ");
		sb.append(layoutPrototypeId);

		runSQL(sb.toString());
	}

	private final CompanyLocalService _companyLocalService;

}