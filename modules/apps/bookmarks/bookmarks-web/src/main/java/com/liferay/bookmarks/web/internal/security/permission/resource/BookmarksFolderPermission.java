/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.web.internal.security.permission.resource;

import com.liferay.bookmarks.model.BookmarksFolder;
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
public class BookmarksFolderPermission {

	public static boolean contains(
			PermissionChecker permissionChecker, BookmarksFolder folder,
			String actionId)
		throws PortalException {

		return _bookmarksFolderModelResourcePermission.contains(
			permissionChecker, folder, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long groupId, long folderId,
			String actionId)
		throws PortalException {

		return ModelResourcePermissionUtil.contains(
			_bookmarksFolderModelResourcePermission, permissionChecker, groupId,
			folderId, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.bookmarks.model.BookmarksFolder)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<BookmarksFolder> modelResourcePermission) {

		_bookmarksFolderModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<BookmarksFolder>
		_bookmarksFolderModelResourcePermission;

}