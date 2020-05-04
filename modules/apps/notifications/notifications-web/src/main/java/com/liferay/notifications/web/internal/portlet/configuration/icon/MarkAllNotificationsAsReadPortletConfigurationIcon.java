/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.notifications.web.internal.portlet.configuration.icon;

import com.liferay.notifications.web.internal.constants.NotificationsPortletKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;
import com.liferay.portal.kernel.portlet.configuration.icon.PortletConfigurationIcon;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + NotificationsPortletKeys.NOTIFICATIONS,
	service = PortletConfigurationIcon.class
)
public class MarkAllNotificationsAsReadPortletConfigurationIcon
	extends BasePortletConfigurationIcon {

	@Override
	public String getMessage(PortletRequest portletRequest) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", getLocale(portletRequest), getClass());

		return LanguageUtil.get(
			resourceBundle, "mark-all-notifications-as-read");
	}

	@Override
	public String getURL(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		PortletURL portletURL = PortletURLFactoryUtil.create(
			portletRequest, NotificationsPortletKeys.NOTIFICATIONS,
			PortletRequest.ACTION_PHASE);

		portletURL.setParameter(
			ActionRequest.ACTION_NAME, "markAllNotificationsAsRead");

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		portletURL.setParameter("redirect", themeDisplay.getURLCurrent());

		return portletURL.toString();
	}

	@Override
	public boolean isShow(PortletRequest portletRequest) {
		if (!ParamUtil.getBoolean(portletRequest, "actionRequired")) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)portletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			int unreadNotificationEventsCount =
				_userNotificationEventLocalService.
					getArchivedUserNotificationEventsCount(
						themeDisplay.getUserId(),
						UserNotificationDeliveryConstants.TYPE_WEBSITE, true,
						false, false);

			if (unreadNotificationEventsCount > 0) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean isToolTip() {
		return false;
	}

	@Reference
	private UserNotificationEventLocalService
		_userNotificationEventLocalService;

}