/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.custom.filter.portlet;

import com.liferay.portal.search.web.internal.util.SearchOptionalUtil;

import java.util.stream.Stream;

/**
 * @author André de Oliveira
 */
public class CustomFilterPortletUtil {

	public static String getParameterName(
		CustomFilterPortletPreferences customFilterPortletPreferences) {

		return SearchOptionalUtil.findFirstPresent(
			Stream.of(
				customFilterPortletPreferences.getParameterNameOptional(),
				customFilterPortletPreferences.getFilterFieldOptional()),
			"customfilter");
	}

}