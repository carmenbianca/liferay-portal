/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.rest.resource.v2_0.test.util;

import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.model.DDLRecordSetConstants;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ResourceLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Locale;
import java.util.Map;

/**
 * @author Marcela Cunha
 */
public class DataRecordCollectionTestUtil {

	public static DDLRecordSet addRecordSet(
			DDMStructure ddmStructure, Group group,
			ResourceLocalService resourceLocalService)
		throws Exception {

		return addRecordSet(
			ddmStructure, group, resourceLocalService,
			DDLRecordSetConstants.SCOPE_DATA_ENGINE);
	}

	public static DDLRecordSet addRecordSet(
			DDMStructure ddmStructure, Group group,
			ResourceLocalService resourceLocalService, int scope)
		throws Exception {

		Map<Locale, String> nameMap = HashMapBuilder.put(
			LocaleUtil.US, RandomTestUtil.randomString()
		).build();

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(group.getGroupId());

		DDLRecordSet ddlRecordSet = DDLRecordSetLocalServiceUtil.addRecordSet(
			TestPropsValues.getUserId(), group.getGroupId(),
			ddmStructure.getStructureId(), ddmStructure.getStructureKey(),
			nameMap, null, DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT,
			scope, serviceContext);

		resourceLocalService.addModelResources(
			TestPropsValues.getCompanyId(), ddmStructure.getGroupId(),
			TestPropsValues.getUserId(), _getResourceName(ddlRecordSet),
			ddlRecordSet.getRecordSetId(),
			serviceContext.getModelPermissions());

		return ddlRecordSet;
	}

	private static String _getResourceName(DDLRecordSet ddlRecordSet)
		throws PortalException {

		DDMStructure ddmStructure = ddlRecordSet.getDDMStructure();

		return ResourceActionsUtil.getCompositeModelName(
			PortalUtil.getClassName(ddmStructure.getClassNameId()),
			DDLRecordSet.class.getName());
	}

}