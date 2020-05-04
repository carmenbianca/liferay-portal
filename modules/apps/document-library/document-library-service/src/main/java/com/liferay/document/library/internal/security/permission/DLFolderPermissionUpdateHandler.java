/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.security.permission;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.portal.kernel.security.permission.PermissionUpdateHandler;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gergely Mathe
 */
@Component(
	property = "model.class.name=com.liferay.document.library.kernel.model.DLFolder",
	service = PermissionUpdateHandler.class
)
public class DLFolderPermissionUpdateHandler
	implements PermissionUpdateHandler {

	@Override
	public void updatedPermission(String primKey) {
		DLFolder dlFolder = _dLFolderLocalService.fetchDLFolder(
			GetterUtil.getLong(primKey));

		if (dlFolder == null) {
			return;
		}

		dlFolder.setModifiedDate(new Date());

		_dLFolderLocalService.updateDLFolder(dlFolder);
	}

	@Reference(unbind = "-")
	protected void setDLFolderLocalService(
		DLFolderLocalService dLFolderLocalService) {

		_dLFolderLocalService = dLFolderLocalService;
	}

	private DLFolderLocalService _dLFolderLocalService;

}