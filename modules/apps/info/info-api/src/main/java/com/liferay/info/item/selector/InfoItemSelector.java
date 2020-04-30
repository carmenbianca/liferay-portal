/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.item.selector;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public interface InfoItemSelector<T> {

	public PortletURL getInfoItemSelectorPortletURL(
			HttpServletRequest httpServletRequest)
		throws Exception;

	public default String getKey() {
		Class<?> clazz = getClass();

		return clazz.getName();
	}

}