/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Zsolt Berentey
 */
public class SocialRequestPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, long requestId,
			String actionId)
		throws PortalException {

		getSocialRequestPermission().check(
			permissionChecker, requestId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long requestId,
			String actionId)
		throws PortalException {

		return getSocialRequestPermission().contains(
			permissionChecker, requestId, actionId);
	}

	public static SocialRequestPermission getSocialRequestPermission() {
		return _socialRequestPermission;
	}

	public void setSocialRequestPermission(
		SocialRequestPermission socialRequestPermission) {

		_socialRequestPermission = socialRequestPermission;
	}

	private static SocialRequestPermission _socialRequestPermission;

}