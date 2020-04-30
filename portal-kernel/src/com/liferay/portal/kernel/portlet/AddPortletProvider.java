/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.PortletPreferences;

/**
 * @author Eudaldo Alonso
 */
public interface AddPortletProvider extends PortletProvider {

	public void updatePortletPreferences(
			PortletPreferences portletPreferences, String portletId,
			String className, long classPK, ThemeDisplay themeDisplay)
		throws Exception;

}