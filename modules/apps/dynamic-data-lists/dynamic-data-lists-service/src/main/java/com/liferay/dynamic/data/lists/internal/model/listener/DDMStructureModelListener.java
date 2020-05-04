/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.internal.model.listener;

import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalService;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marcellus Tavares
 */
@Component(immediate = true, service = ModelListener.class)
public class DDMStructureModelListener extends BaseModelListener<DDMStructure> {

	@Override
	public void onAfterUpdate(DDMStructure ddmStructure)
		throws ModelListenerException {

		try {
			ActionableDynamicQuery actionableDynamicQuery =
				getActionableDynamicQuery(ddmStructure);

			actionableDynamicQuery.performActions();
		}
		catch (PortalException portalException) {
			throw new ModelListenerException(portalException);
		}
	}

	protected ActionableDynamicQuery getActionableDynamicQuery(
		DDMStructure ddmStructure) {

		ActionableDynamicQuery actionableDynamicQuery =
			_ddlRecordSetLocalService.getActionableDynamicQuery();

		actionableDynamicQuery.setAddCriteriaMethod(
			dynamicQuery -> {
				Property ddmStructureIdProperty = PropertyFactoryUtil.forName(
					"DDMStructureId");

				dynamicQuery.add(
					ddmStructureIdProperty.eq(ddmStructure.getStructureId()));
			});
		actionableDynamicQuery.setPerformActionMethod(
			(DDLRecordSet recordSet) -> {
				Locale siteLocale = null;

				if (ExportImportThreadLocal.isImportInProcess()) {
					siteLocale = LocaleThreadLocal.getSiteDefaultLocale();

					Locale stagingLocale = LocaleUtil.fromLanguageId(
						ddmStructure.getDefaultLanguageId());

					LocaleThreadLocal.setSiteDefaultLocale(stagingLocale);
				}

				ServiceContext serviceContext = new ServiceContext();

				serviceContext.setAddGuestPermissions(true);
				serviceContext.setAddGroupPermissions(true);

				serviceContext.setScopeGroupId(recordSet.getGroupId());

				long defaultUserId = _userLocalService.getDefaultUserId(
					recordSet.getCompanyId());

				serviceContext.setUserId(defaultUserId);

				try {
					_ddlRecordSetLocalService.updateRecordSet(
						recordSet.getRecordSetId(),
						ddmStructure.getStructureId(), recordSet.getNameMap(),
						recordSet.getDescriptionMap(),
						recordSet.getMinDisplayRows(), serviceContext);
				}
				finally {
					if (ExportImportThreadLocal.isImportInProcess()) {
						LocaleThreadLocal.setSiteDefaultLocale(siteLocale);
					}
				}
			});

		return actionableDynamicQuery;
	}

	@Reference
	private DDLRecordSetLocalService _ddlRecordSetLocalService;

	@Reference
	private UserLocalService _userLocalService;

}