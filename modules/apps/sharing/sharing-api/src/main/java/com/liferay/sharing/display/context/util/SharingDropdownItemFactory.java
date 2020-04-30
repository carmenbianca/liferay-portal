/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.display.context.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.portal.kernel.exception.PortalException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alejandro Tardín
 */
public interface SharingDropdownItemFactory {

	public DropdownItem createManageCollaboratorsDropdownItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException;

	public DropdownItem createShareDropdownItem(
			String className, long classPK,
			HttpServletRequest httpServletRequest)
		throws PortalException;

}