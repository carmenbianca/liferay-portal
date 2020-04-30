/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.helper;

import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.model.DDLRecordSetConstants;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.StorageType;
import com.liferay.dynamic.data.mapping.test.util.DDMStructureTestHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
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
 * @author Marcellus Tavares
 * @author André de Oliveira
 */
public class DDLRecordSetTestHelper {

	public DDLRecordSetTestHelper(Group group) throws Exception {
		_group = group;
	}

	public DDLRecordSet addRecordSet(DDMForm ddmForm) throws Exception {
		DDMStructureTestHelper ddmStructureTestHelper =
			new DDMStructureTestHelper(
				PortalUtil.getClassNameId(DDLRecordSet.class), _group);

		DDMStructure ddmStructure = ddmStructureTestHelper.addStructure(
			ddmForm, StorageType.JSON.toString());

		return addRecordSet(ddmStructure);
	}

	public DDLRecordSet addRecordSet(DDMStructure ddmStructure)
		throws Exception {

		return addRecordSet(
			ddmStructure, DDLRecordSetConstants.SCOPE_DYNAMIC_DATA_LISTS);
	}

	public DDLRecordSet addRecordSet(DDMStructure ddmStructure, int scope)
		throws Exception {

		Map<Locale, String> nameMap = HashMapBuilder.put(
			LocaleUtil.US, RandomTestUtil.randomString()
		).build();

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(_group.getGroupId());

		return DDLRecordSetLocalServiceUtil.addRecordSet(
			TestPropsValues.getUserId(), _group.getGroupId(),
			ddmStructure.getStructureId(), null, nameMap, null,
			DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT, scope,
			serviceContext);
	}

	public DDLRecordSet updateRecordSet(
			long recordSetId, DDMFormValues settingsDDMFormValues)
		throws PortalException {

		return DDLRecordSetLocalServiceUtil.updateRecordSet(
			recordSetId, settingsDDMFormValues);
	}

	public DDLRecordSet updateRecordSet(
			long recordSetId, DDMStructure ddmStructure)
		throws Exception {

		Map<Locale, String> nameMap = HashMapBuilder.put(
			LocaleUtil.US, RandomTestUtil.randomString()
		).build();

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(_group.getGroupId());

		return DDLRecordSetLocalServiceUtil.updateRecordSet(
			recordSetId, ddmStructure.getStructureId(), nameMap, null,
			DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT, serviceContext);
	}

	private final Group _group;

}