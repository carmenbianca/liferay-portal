/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender.sms.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Andrea Di Giorgi
 */
@ExtendedObjectClassDefinition(category = "notifications")
@Meta.OCD(
	id = "com.liferay.push.notifications.sender.sms.internal.configuration.SMSPushNotificationsSenderConfiguration",
	localization = "content/Language",
	name = "sms-push-notifications-sender-configuration-name"
)
public interface SMSPushNotificationsSenderConfiguration {

	@Meta.AD(name = "account.sid.name", required = false)
	public String accountSID();

	@Meta.AD(name = "authentication.token.name", required = false)
	public String authToken();

	@Meta.AD(name = "number.name", required = false)
	public String number();

	@Meta.AD(name = "status.callback.name", required = false)
	public String statusCallback();

}