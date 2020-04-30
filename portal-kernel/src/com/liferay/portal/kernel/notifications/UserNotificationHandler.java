/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.notifications;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author Jonathan Lee
 */
public interface UserNotificationHandler {

	public String getPortletId();

	public String getSelector();

	public UserNotificationFeedEntry interpret(
			UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext)
		throws PortalException;

	public default boolean isApplicable(
		UserNotificationEvent userNotificationEvent,
		ServiceContext serviceContext) {

		return true;
	}

	public boolean isDeliver(
			long userId, long classNameId, int notificationType,
			int deliveryType, ServiceContext serviceContext)
		throws PortalException;

	public boolean isOpenDialog();

}