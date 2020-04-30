/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.notifications;

import com.liferay.blogs.constants.BlogsPortletKeys;
import com.liferay.portal.kernel.notifications.BaseModelUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true, property = "javax.portlet.name=" + BlogsPortletKeys.BLOGS,
	service = UserNotificationHandler.class
)
public class BlogsUserNotificationHandler
	extends BaseModelUserNotificationHandler {

	public BlogsUserNotificationHandler() {
		setPortletId(BlogsPortletKeys.BLOGS);
	}

}