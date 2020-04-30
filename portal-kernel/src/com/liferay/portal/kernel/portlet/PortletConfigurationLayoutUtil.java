/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;

/**
 * @author Raymond Augé
 */
public class PortletConfigurationLayoutUtil {

	public static Layout getLayout(ThemeDisplay themeDisplay) {
		Layout layout = themeDisplay.getLayout();

		if (layout.isTypeControlPanel() &&
			(themeDisplay.getScopeGroupId() != layout.getGroupId())) {

			return null;
		}

		return layout;
	}

}