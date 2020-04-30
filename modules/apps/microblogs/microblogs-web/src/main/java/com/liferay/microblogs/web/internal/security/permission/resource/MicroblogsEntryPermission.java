/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.microblogs.web.internal.security.permission.resource;

import com.liferay.microblogs.model.MicroblogsEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(immediate = true, service = {})
public class MicroblogsEntryPermission {

	public static boolean contains(
			PermissionChecker permissionChecker, long microblogsEntryId,
			String actionId)
		throws PortalException {

		return _microblogsEntryModelResourcePermission.contains(
			permissionChecker, microblogsEntryId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker,
			MicroblogsEntry microblogsEntry, String actionId)
		throws PortalException {

		return _microblogsEntryModelResourcePermission.contains(
			permissionChecker, microblogsEntry, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.microblogs.model.MicroblogsEntry)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<MicroblogsEntry> modelResourcePermission) {

		_microblogsEntryModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<MicroblogsEntry>
		_microblogsEntryModelResourcePermission;

}