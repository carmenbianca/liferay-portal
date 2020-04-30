/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.notifications;

import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.portal.kernel.notifications.BaseModelUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roberto Díaz
 */
@Component(
	property = "javax.portlet.name=" + DLPortletKeys.DOCUMENT_LIBRARY,
	service = UserNotificationHandler.class
)
public class DLUserNotificationHandler
	extends BaseModelUserNotificationHandler {

	public DLUserNotificationHandler() {
		setPortletId(DLPortletKeys.DOCUMENT_LIBRARY);
	}

}