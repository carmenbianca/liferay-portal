/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.web.internal.portlet.action;

import com.liferay.bookmarks.constants.BookmarksPortletKeys;
import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 * @author Levente Hudák
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS,
		"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS_ADMIN,
		"mvc.command.name=/bookmarks/edit_entry"
	},
	service = MVCRenderCommand.class
)
public class EditEntryMVCRenderCommand extends GetEntryMVCRenderCommand {

	@Override
	protected void checkPermissions(
			PermissionChecker permissionChecker, BookmarksEntry entry)
		throws PortalException {

		_bookmarksEntryModelResourcePermission.check(
			permissionChecker, entry, ActionKeys.UPDATE);
	}

	@Override
	protected String getPath() {
		return "/bookmarks/edit_entry.jsp";
	}

	@Reference(
		target = "(model.class.name=com.liferay.bookmarks.model.BookmarksEntry)"
	)
	private volatile ModelResourcePermission<BookmarksEntry>
		_bookmarksEntryModelResourcePermission;

}