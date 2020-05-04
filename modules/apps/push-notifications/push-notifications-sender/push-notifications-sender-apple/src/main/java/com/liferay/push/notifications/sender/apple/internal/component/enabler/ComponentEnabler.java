/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender.apple.internal.component.enabler;

import com.liferay.osgi.util.ComponentUtil;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.push.notifications.constants.PushNotificationsDestinationNames;
import com.liferay.push.notifications.sender.apple.internal.messaging.ApplePushNotificationsMessagingConfigurator;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = {})
public class ComponentEnabler {

	@Activate
	protected void activate(ComponentContext componentContext) {
		ComponentUtil.enableComponents(
			Destination.class,
			"(destination.name= " +
				PushNotificationsDestinationNames.PUSH_NOTIFICATION_RESPONSE +
					")",
			componentContext,
			ApplePushNotificationsMessagingConfigurator.class);
	}

}