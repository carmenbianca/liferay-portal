/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;

/**
 * @author Raymond Augé
 */
public class LayoutTypePortletFactoryUtil {

	public static LayoutTypePortlet create(Layout layout) {
		return getLayoutTypePortletFactory().create(layout);
	}

	public static LayoutTypePortletFactory getLayoutTypePortletFactory() {
		return _layoutTypePortletFactory;
	}

	public void setLayoutTypePortletFactory(
		LayoutTypePortletFactory layoutTypePortletFactory) {

		_layoutTypePortletFactory = layoutTypePortletFactory;
	}

	private static LayoutTypePortletFactory _layoutTypePortletFactory;

}