/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.display.context.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.servlet.taglib.ui.MenuItem;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Adolfo Pérez
 */
public interface SharingMenuItemFactory {

	public MenuItem createManageCollaboratorsMenuItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException;

	public MenuItem createShareMenuItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException;

}