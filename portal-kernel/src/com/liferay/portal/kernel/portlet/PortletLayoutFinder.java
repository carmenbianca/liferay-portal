/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;

/**
 * @author Adolfo Pérez
 */
public interface PortletLayoutFinder {

	public Result find(ThemeDisplay themeDisplay, long groupId)
		throws PortalException;

	public interface Result {

		public long getPlid();

		public String getPortletId();

	}

}