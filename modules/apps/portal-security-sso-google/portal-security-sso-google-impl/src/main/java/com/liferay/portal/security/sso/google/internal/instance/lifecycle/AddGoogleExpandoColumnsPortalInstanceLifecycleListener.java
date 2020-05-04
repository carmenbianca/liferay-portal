/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.google.internal.instance.lifecycle;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class AddGoogleExpandoColumnsPortalInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstancePreunregistered(Company company)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(
			User.class.getName());

		ExpandoTable expandoTable = _expandoTableLocalService.fetchTable(
			company.getCompanyId(), classNameId,
			ExpandoTableConstants.DEFAULT_TABLE_NAME);

		_expandoColumnLocalService.deleteColumn(
			expandoTable.getTableId(), "googleAccessToken");
		_expandoColumnLocalService.deleteColumn(
			expandoTable.getTableId(), "googleRefreshToken");

		List<ExpandoColumn> expandoColumns =
			_expandoColumnLocalService.getColumns(expandoTable.getTableId());

		if (expandoColumns.isEmpty()) {
			_expandoTableLocalService.deleteExpandoTable(expandoTable);
		}
	}

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		Long companyId = CompanyThreadLocal.getCompanyId();

		try {
			CompanyThreadLocal.setCompanyId(company.getCompanyId());

			long classNameId = _classNameLocalService.getClassNameId(
				User.class.getName());

			ExpandoTable expandoTable = _expandoTableLocalService.fetchTable(
				company.getCompanyId(), classNameId,
				ExpandoTableConstants.DEFAULT_TABLE_NAME);

			if (expandoTable == null) {
				expandoTable = _expandoTableLocalService.addTable(
					company.getCompanyId(), classNameId,
					ExpandoTableConstants.DEFAULT_TABLE_NAME);
			}

			UnicodeProperties unicodeProperties = new UnicodeProperties();

			unicodeProperties.setProperty("hidden", "true");
			unicodeProperties.setProperty(
				"visible-with-update-permission", "false");

			addExpandoColumn(
				expandoTable, "googleAccessToken", unicodeProperties);
			addExpandoColumn(
				expandoTable, "googleRefreshToken", unicodeProperties);
		}
		finally {
			CompanyThreadLocal.setCompanyId(companyId);
		}
	}

	@Override
	public void portalInstanceUnregistered(Company company) throws Exception {
	}

	protected void addExpandoColumn(
			ExpandoTable expandoTable, String name,
			UnicodeProperties unicodeProperties)
		throws Exception {

		ExpandoColumn expandoColumn = _expandoColumnLocalService.getColumn(
			expandoTable.getTableId(), name);

		if (expandoColumn != null) {
			return;
		}

		expandoColumn = _expandoColumnLocalService.addColumn(
			expandoTable.getTableId(), name, ExpandoColumnConstants.STRING);

		_expandoColumnLocalService.updateTypeSettings(
			expandoColumn.getColumnId(), unicodeProperties.toString());
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private ExpandoColumnLocalService _expandoColumnLocalService;

	@Reference
	private ExpandoTableLocalService _expandoTableLocalService;

}