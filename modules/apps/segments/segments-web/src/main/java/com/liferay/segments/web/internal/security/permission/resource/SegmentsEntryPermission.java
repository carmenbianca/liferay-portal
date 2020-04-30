/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.segments.model.SegmentsEntry;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(immediate = true, service = {})
public class SegmentsEntryPermission {

	public static boolean contains(
			PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException {

		return _segmentsEntryModelResourcePermission.contains(
			permissionChecker, entryId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, SegmentsEntry segmentsEntry,
			String actionId)
		throws PortalException {

		return _segmentsEntryModelResourcePermission.contains(
			permissionChecker, segmentsEntry, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.segments.model.SegmentsEntry)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<SegmentsEntry> modelResourcePermission) {

		_segmentsEntryModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<SegmentsEntry>
		_segmentsEntryModelResourcePermission;

}