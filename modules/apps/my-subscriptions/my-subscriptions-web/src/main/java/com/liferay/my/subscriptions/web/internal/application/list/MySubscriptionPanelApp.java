/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.my.subscriptions.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.my.subscriptions.web.internal.constants.MySubscriptionsPortletKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Fellwock
 */
@Component(
	enabled = false, immediate = true,
	property = {
		"panel.app.order:Integer=600",
		"panel.category.key=" + PanelCategoryKeys.USER_MY_ACCOUNT
	},
	service = PanelApp.class
)
public class MySubscriptionPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return MySubscriptionsPortletKeys.MY_SUBSCRIPTIONS;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + MySubscriptionsPortletKeys.MY_SUBSCRIPTIONS + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}