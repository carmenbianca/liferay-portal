/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.web.internal.portlet.action;

import com.liferay.bookmarks.constants.BookmarksPortletKeys;
import com.liferay.bookmarks.model.BookmarksFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS,
		"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS_ADMIN,
		"mvc.command.name=/bookmarks/edit_folder"
	},
	service = MVCRenderCommand.class
)
public class EditFolderMVCRenderCommand extends GetFolderMVCRenderCommand {

	@Override
	protected void checkPermissions(
			PermissionChecker permissionChecker, BookmarksFolder folder)
		throws PortalException {

		_bookmarksFolderModelResourcePermission.check(
			permissionChecker, folder, ActionKeys.UPDATE);
	}

	@Override
	protected String getPath() {
		return "/bookmarks/edit_folder.jsp";
	}

	@Reference(
		target = "(model.class.name=com.liferay.bookmarks.model.BookmarksFolder)"
	)
	private volatile ModelResourcePermission<BookmarksFolder>
		_bookmarksFolderModelResourcePermission;

}