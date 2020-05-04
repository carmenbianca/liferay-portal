/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.notifications.web.internal.portlet;

import com.liferay.application.list.PanelApp;
import com.liferay.notifications.web.internal.constants.NotificationsPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.portal.kernel.model.UserNotificationEvent",
	service = ViewPortletProvider.class
)
public class NotificationsViewPortletProvider
	extends BasePortletProvider implements ViewPortletProvider {

	@Override
	public String getPortletName() {
		return NotificationsPortletKeys.NOTIFICATIONS;
	}

	@Override
	public PortletURL getPortletURL(HttpServletRequest httpServletRequest)
		throws PortalException {

		return _panelApp.getPortletURL(httpServletRequest);
	}

	@Override
	public PortletURL getPortletURL(
			HttpServletRequest httpServletRequest, Group group)
		throws PortalException {

		return getPortletURL(httpServletRequest);
	}

	@Reference(
		target = "(javax.portlet.name=" + NotificationsPortletKeys.NOTIFICATIONS + ")",
		unbind = "-"
	)
	protected void setPanelApp(PanelApp panelApp) {
		_panelApp = panelApp;
	}

	private PanelApp _panelApp;

}