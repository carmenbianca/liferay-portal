/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.security.permission;

import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalService;
import com.liferay.portal.kernel.security.permission.PermissionUpdateHandler;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gergely Mathe
 */
@Component(
	property = "model.class.name=com.liferay.document.library.kernel.model.DLFileEntryType",
	service = PermissionUpdateHandler.class
)
public class DLFileEntryTypePermissionUpdateHandler
	implements PermissionUpdateHandler {

	@Override
	public void updatedPermission(String primKey) {
		DLFileEntryType dlFileEntryType =
			_dLFileEntryTypeLocalService.fetchDLFileEntryType(
				GetterUtil.getLong(primKey));

		if (dlFileEntryType == null) {
			return;
		}

		dlFileEntryType.setModifiedDate(new Date());

		_dLFileEntryTypeLocalService.updateDLFileEntryType(dlFileEntryType);
	}

	@Reference(unbind = "-")
	protected void setDLFileEntryTypeLocalService(
		DLFileEntryTypeLocalService dLFileEntryTypeLocalService) {

		_dLFileEntryTypeLocalService = dLFileEntryTypeLocalService;
	}

	private DLFileEntryTypeLocalService _dLFileEntryTypeLocalService;

}