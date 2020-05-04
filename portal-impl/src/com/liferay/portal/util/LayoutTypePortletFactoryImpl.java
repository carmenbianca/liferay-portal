/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypeAccessPolicy;
import com.liferay.portal.kernel.model.LayoutTypeController;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.util.LayoutTypePortletFactory;
import com.liferay.portal.model.impl.LayoutTypePortletImpl;
import com.liferay.portal.model.impl.LayoutTypeURLImpl;

/**
 * @author Raymond Augé
 */
public class LayoutTypePortletFactoryImpl implements LayoutTypePortletFactory {

	@Override
	public LayoutTypePortlet create(Layout layout) {
		LayoutTypeController layoutTypeController =
			LayoutTypeControllerTracker.getLayoutTypeController(
				layout.getType());

		LayoutTypeAccessPolicy layoutTypeAccessPolicy =
			LayoutTypeAccessPolicyTracker.getLayoutTypeAccessPolicy(layout);

		if (layout.isTypeURL()) {
			return new LayoutTypeURLImpl(
				layout, layoutTypeController, layoutTypeAccessPolicy);
		}

		return new LayoutTypePortletImpl(
			layout, layoutTypeController, layoutTypeAccessPolicy);
	}

}