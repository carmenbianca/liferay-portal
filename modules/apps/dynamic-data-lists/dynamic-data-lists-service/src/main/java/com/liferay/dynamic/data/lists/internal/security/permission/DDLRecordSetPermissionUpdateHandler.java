/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.internal.security.permission;

import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalService;
import com.liferay.portal.kernel.security.permission.PermissionUpdateHandler;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gergely Mathe
 */
@Component(
	property = "model.class.name=com.liferay.dynamic.data.lists.model.DDLRecordSet",
	service = PermissionUpdateHandler.class
)
public class DDLRecordSetPermissionUpdateHandler
	implements PermissionUpdateHandler {

	@Override
	public void updatedPermission(String primKey) {
		DDLRecordSet ddlRecordSet = _ddlRecordSetLocalService.fetchDDLRecordSet(
			GetterUtil.getLong(primKey));

		if (ddlRecordSet == null) {
			return;
		}

		ddlRecordSet.setModifiedDate(new Date());

		_ddlRecordSetLocalService.updateDDLRecordSet(ddlRecordSet);
	}

	@Reference(unbind = "-")
	protected void setDDLRecordSetLocalService(
		DDLRecordSetLocalService ddlRecordSetLocalService) {

		_ddlRecordSetLocalService = ddlRecordSetLocalService;
	}

	private DDLRecordSetLocalService _ddlRecordSetLocalService;

}