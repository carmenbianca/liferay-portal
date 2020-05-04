/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.security.permission.resource;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(service = {})
public class DLFolderPermission {

	public static void check(
			PermissionChecker permissionChecker, DLFolder dlFolder,
			String actionId)
		throws PortalException {

		_dlFolderModelResourcePermission.check(
			permissionChecker, dlFolder, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, Folder folder, String actionId)
		throws PortalException {

		_folderModelResourcePermission.check(
			permissionChecker, folder, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long groupId, long folderId,
			String actionId)
		throws PortalException {

		ModelResourcePermissionUtil.check(
			_folderModelResourcePermission, permissionChecker, groupId,
			folderId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, DLFolder dlFolder,
			String actionId)
		throws PortalException {

		return _dlFolderModelResourcePermission.contains(
			permissionChecker, dlFolder, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, Folder folder, String actionId)
		throws PortalException {

		return _folderModelResourcePermission.contains(
			permissionChecker, folder, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long groupId, long folderId,
			String actionId)
		throws PortalException {

		return ModelResourcePermissionUtil.contains(
			_folderModelResourcePermission, permissionChecker, groupId,
			folderId, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.document.library.kernel.model.DLFolder)",
		unbind = "-"
	)
	protected void setDLFolderModelResourcePermission(
		ModelResourcePermission<DLFolder> modelResourcePermission) {

		_dlFolderModelResourcePermission = modelResourcePermission;
	}

	@Reference(
		target = "(model.class.name=com.liferay.portal.kernel.repository.model.Folder)",
		unbind = "-"
	)
	protected void setFolderModelResourcePermission(
		ModelResourcePermission<Folder> modelResourcePermission) {

		_folderModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<DLFolder>
		_dlFolderModelResourcePermission;
	private static ModelResourcePermission<Folder>
		_folderModelResourcePermission;

}