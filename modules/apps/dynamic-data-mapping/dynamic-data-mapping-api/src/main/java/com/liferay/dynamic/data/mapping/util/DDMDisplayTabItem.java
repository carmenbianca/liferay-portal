/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;

/**
 * @author Alejandro Tardín
 */
public interface DDMDisplayTabItem {

	public String getTitle(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse);

	public default String getURL(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		return null;
	}

	public default boolean isShow(LiferayPortletRequest liferayPortletRequest) {
		return true;
	}

}