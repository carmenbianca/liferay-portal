/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.security.permission.resource;

import com.liferay.journal.model.JournalFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(immediate = true, service = {})
public class JournalFolderPermission {

	public static boolean contains(
			PermissionChecker permissionChecker, JournalFolder folder,
			String actionId)
		throws PortalException {

		return _journalFolderModelResourcePermission.contains(
			permissionChecker, folder, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long groupId, long folderId,
			String actionId)
		throws PortalException {

		return ModelResourcePermissionUtil.contains(
			_journalFolderModelResourcePermission, permissionChecker, groupId,
			folderId, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.journal.model.JournalFolder)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<JournalFolder> modelResourcePermission) {

		_journalFolderModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<JournalFolder>
		_journalFolderModelResourcePermission;

}